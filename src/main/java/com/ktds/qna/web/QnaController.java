package com.ktds.qna.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.qna.service.QnaService;
import com.ktds.qna.vo.QnaVO;

@Controller
public class QnaController {
	
	@Autowired
	QnaService qnaService;
	
	@GetMapping("/qna/qna")
	public ModelAndView viewQnaPage() {
		ModelAndView view = new ModelAndView("qna/qna");
		List<QnaVO> qnaList = this.qnaService.readAllQna();
		view.addObject("qnaList", qnaList);
		return view;
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
		
		return view;
	}

}
