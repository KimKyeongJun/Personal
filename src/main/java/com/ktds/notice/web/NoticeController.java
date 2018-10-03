package com.ktds.notice.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.common.session.Session;
import com.ktds.member.vo.MemberVO;
import com.ktds.notice.service.NoticeService;
import com.ktds.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/notice/notice")
	public ModelAndView viewNoticePage() {
		ModelAndView view = new ModelAndView("notice/notice");
		List<NoticeVO> noticeList = this.noticeService.findAllNotice();
		
		view.addObject("noticeList", noticeList);
		
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
	

}
