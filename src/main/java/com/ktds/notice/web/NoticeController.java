package com.ktds.notice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
	
	@GetMapping("/notice/notice")
	public String viewNoticePage() {
		return "notice/notice";
	}
	
	@GetMapping("/notice/regist")
	public String viewNoticeRegistPage() {
		return "notice/regist";
	}
	

}