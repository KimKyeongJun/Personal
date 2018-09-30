package com.ktds.qnareply.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktds.qnareply.service.QnaReplyService;
import com.ktds.qnareply.vo.QnaReplyVO;

@Controller
public class QnaReplyController {
	
	@Autowired
	private QnaReplyService qnaReplyService;

	@PostMapping("/qna/reply")
	@ResponseBody
	public Map<String, Object> doQnaReplyAction(@ModelAttribute QnaReplyVO qnaReplyVO) {
		Map<String, Object> result = new HashMap<>();
		boolean isRegist = this.qnaReplyService.registOneQnaReply(qnaReplyVO);
		result.put("regist", isRegist);
		return result;		
	}
	
}
