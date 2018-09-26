package com.ktds.qna.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnaController {
	
	@GetMapping("/qna/qna")
	public String viewQnaPage() {
		return "qna/qna";
	}
	
	@GetMapping("/qna/regist")
	public String viewQnaRegistPage() {
		return "qna/regist";
	}

}
