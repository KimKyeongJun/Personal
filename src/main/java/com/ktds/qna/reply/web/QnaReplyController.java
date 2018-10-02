package com.ktds.qna.reply.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktds.qna.reply.service.QnaReplyService;
import com.ktds.qna.reply.vo.QnaReplyVO;
import com.nhncorp.lucy.security.xss.XssFilter;

@Controller
public class QnaReplyController {
	
	@Autowired
	private QnaReplyService qnaReplyService;

	@PostMapping("/qna/reply")
	@ResponseBody
	public Map<String, Object> doQnaReplyAction(@ModelAttribute QnaReplyVO qnaReplyVO) {
		Map<String, Object> result = new HashMap<>();
		
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		qnaReplyVO.setContent(filter.doFilter(qnaReplyVO.getContent()));
		boolean isRegist = this.qnaReplyService.registOneQnaReply(qnaReplyVO);
		result.put("regist", isRegist);
		return result;
	}	
}
