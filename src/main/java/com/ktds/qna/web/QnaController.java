package com.ktds.qna.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.common.session.Session;
import com.ktds.qna.reply.vo.QnaReplyVO;
import com.ktds.qna.service.QnaService;
import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;
import com.nhncorp.lucy.security.xss.XssFilter;

import io.github.seccoding.web.pager.explorer.PageExplorer;

@Controller
public class QnaController {
	
	@Autowired
	QnaService qnaService;
	
	@RequestMapping("/qna/qna")
	public ModelAndView viewQnaListPage(@ModelAttribute QnaSearchVO qnaSearchVO, HttpServletRequest request, HttpSession session) {
		// 전체 검색 or 상세 -> 목록 or 글쓰기
				if ( qnaSearchVO.getSearchKeyword() == null ) {
					qnaSearchVO = (QnaSearchVO) session.getAttribute(Session.QNASEARCH);
					if ( qnaSearchVO == null ) {
						qnaSearchVO = new QnaSearchVO();
						qnaSearchVO.setPageNo(0);
					}
				}
				
				//html태그, 게시글, 페이지정보
				PageExplorer pageExplorer = this.qnaService.readAllQna(qnaSearchVO);
				XssFilter xssFilter = XssFilter.getInstance("lucy-xss-superset.xml");
				for ( Object qnaVO : pageExplorer.getList() ) {
					QnaVO convertVO = (QnaVO) qnaVO;
					convertVO.setSubject(xssFilter.doFilter(convertVO.getSubject()));
					convertVO.setContent(xssFilter.doFilter(convertVO.getContent()));
				}
				
				
				session.setAttribute(Session.QNASEARCH, qnaSearchVO);
				
				ModelAndView view = new ModelAndView("qna/qna");
				view.addObject("qnaList", pageExplorer.getList());
				view.addObject("pagenation", pageExplorer.make());
				view.addObject("qnaSearchVO", qnaSearchVO);
				return view;
	}
	
	@RequestMapping("/qna/init")
	public String viewBoardListPageForInitiate(HttpSession session) {
		session.removeAttribute(Session.QNASEARCH);
		return "redirect:/qna/qna";
	}
	
	@GetMapping("/qna/regist")
	public String viewQnaRegistPage() {
		return "qna/regist";
	}
	
	@PostMapping("/qna/regist")
	@ResponseBody
	public Map<String, Object> doQndRegistAction(@ModelAttribute QnaVO qnaVO) {
		Map<String, Object> result = new HashMap<>();
		
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		qnaVO.setWriter(filter.doFilter(qnaVO.getWriter()));
		qnaVO.setSubject(filter.doFilter(qnaVO.getSubject()));
		qnaVO.setContent(filter.doFilter(qnaVO.getContent()));
		boolean isRegist = qnaService.createQna(qnaVO);
		
		if ( isRegist ) {
			result.put("success", isRegist);
			return result;
		}
		
		else {
			result.put("success", isRegist);
		}
		return result;
	}
	
	@GetMapping("/qna/detail")
	public ModelAndView viewQnaDetailPage(@RequestParam String qnaId) {
		ModelAndView view = new ModelAndView("qna/detail");
		QnaVO oneQnaVO = this.qnaService.readOneQna(qnaId);
		System.out.println("QnaController 출력" + qnaId);
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		oneQnaVO.setWriter(filter.doFilter(oneQnaVO.getWriter()));
		oneQnaVO.setSubject(filter.doFilter(oneQnaVO.getSubject()));
		oneQnaVO.setContent(filter.doFilter(oneQnaVO.getContent()));
		
		if ( oneQnaVO.getQnaReplyList() != null ) {			
			for (QnaReplyVO qnaReplyVO : oneQnaVO.getQnaReplyList()) {
				qnaReplyVO.setContent(filter.doFilter(qnaReplyVO.getContent()));
			}
			view.addObject("qnaReplyList",oneQnaVO.getQnaReplyList());
		}
		view.addObject("qna", oneQnaVO);
		
		return view;
	}
	
	@GetMapping("/qna/password")
	public ModelAndView viewPasswordChcekPage(@RequestParam String qnaId) {
		ModelAndView view = new ModelAndView("qna/password");
		view.addObject("qnaId", qnaId);
		return view;
	}
	
	@PostMapping("/qna/password")
	@ResponseBody
	public Map<String, Object> doDetailPasswordCheck(@ModelAttribute QnaVO qnaVO) {
		Map<String, Object> result = new HashMap<>();
		String detailQnaId = this.qnaService.readOneQnaCheck(qnaVO.getQnaId(), qnaVO.getPassword());
		if (detailQnaId != null ) {
			result.put("qnaId", detailQnaId);
			result.put("status", true);
		}
		else {
			result.put("status", false);
		}
		return result;
	}

}
