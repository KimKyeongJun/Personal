package com.ktds.qna.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.common.session.Session;
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
	public ModelAndView viewQnaPage(@ModelAttribute QnaSearchVO qnaSearchVO, HttpServletRequest request, HttpSession session) {
		// 전체 검색 or 상세 -> 목록 or 글쓰기
				if ( qnaSearchVO.getSearchKeyword() == null ) {
					qnaSearchVO = (QnaSearchVO) session.getAttribute(Session.SERARCH);
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
				
				
				session.setAttribute(Session.SERARCH, qnaSearchVO);
				
				ModelAndView view = new ModelAndView("qna/qna");
				view.addObject("qnaList", pageExplorer.getList());
				view.addObject("pagenation", pageExplorer.make());
				view.addObject("qnaSearchVO", qnaSearchVO);
				return view;
	}
	
	@RequestMapping("/qna/init")
	public String viewBoardListPageForInitiate(HttpSession session) {
		session.removeAttribute(Session.SERARCH);
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
	
	@GetMapping("/qna/detail/{qnaId}")
	public ModelAndView viewQnaDetailPage(@PathVariable String qnaId) {
		ModelAndView view = new ModelAndView("qna/detail");
		QnaVO oneQnaVO = this.qnaService.readOneQna(qnaId);
		view.addObject("qna", oneQnaVO);
		
		return view;
	}

}
