package com.ktds.notice.web;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.common.session.Session;
import com.ktds.member.vo.MemberVO;
import com.ktds.notice.service.NoticeService;
import com.ktds.notice.vo.NoticeSearchVO;
import com.ktds.notice.vo.NoticeVO;
import com.nhncorp.lucy.security.xss.XssFilter;

import io.github.seccoding.web.pager.explorer.PageExplorer;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/notice/notice")
	public ModelAndView viewNoticePage(@ModelAttribute NoticeSearchVO noticeSearchVO, HttpServletRequest request, HttpSession session) {
		ModelAndView view = new ModelAndView("notice/notice");
		if ( noticeSearchVO.getSearchKeyword() == null ) {
			noticeSearchVO = (NoticeSearchVO) session.getAttribute(Session.NOTICESERARCH);
			if ( noticeSearchVO == null ) {
				noticeSearchVO = new NoticeSearchVO();
				noticeSearchVO.setPageNo(0);
			}
		}
		
		//html태그, 게시글, 페이지정보
		PageExplorer pageExplorer = this.noticeService.findAllNotice(noticeSearchVO);
		XssFilter xssFilter = XssFilter.getInstance("lucy-xss-superset.xml");
		for ( Object noticeVO : pageExplorer.getList() ) {
			NoticeVO convertVO = (NoticeVO) noticeVO;
			convertVO.setSubject(xssFilter.doFilter(convertVO.getSubject()));
			convertVO.setContent(xssFilter.doFilter(convertVO.getContent()));
		}
		
		
		session.setAttribute(Session.NOTICESERARCH, noticeSearchVO);
		view.addObject("noticeList", pageExplorer.getList());
		view.addObject("pagenation", pageExplorer.make());
		view.addObject("qnaSearchVO", noticeSearchVO);
		
		return view;
	}
	
	@GetMapping("/notice/regist")
	public String viewNoticeRegistPage() {
		return "notice/regist";
	}
	
	@PostMapping("/notice/regist")
	@ResponseBody
	public Map<String, Object> doNoticeRegistAction (@ModelAttribute NoticeVO noticeVO, HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		MemberVO loginMemberVO = (MemberVO) session.getAttribute(Session.USER);
		System.out.println(noticeVO.getContent());
		noticeVO.setAdminId(loginMemberVO.getId());
		
		boolean isRegist = this.noticeService.createOnaNotice(noticeVO);
		
		result.put("status", isRegist);
		return result;
	}
	
	@GetMapping("/notice/detail/{noticeId}")
	public ModelAndView viewNoticeDetailPage(@PathVariable String noticeId) {
		ModelAndView view = new ModelAndView("notice/detail");
		NoticeVO noticeVO = this.noticeService.findOneNotice(noticeId);
		view.addObject("notice", noticeVO);
		return view;
	}
	
	

}
