package com.ktds.member.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktds.member.service.MemberService;
import com.ktds.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/regist")
	public String viewRegistMemberPage() {
		return "member/regist";
	}
	
	@PostMapping("/member/regist")
	@ResponseBody
	public Map<String, Object> doMemberRegistAction (@ModelAttribute MemberVO memberVO) {
		Map<String, Object> result = new HashMap<>();
		boolean isRegistMember = memberService.createMember(memberVO);
		
		if ( isRegistMember ) {
			result.put("regist",isRegistMember);			
		}
		else {
			result.put("regist", isRegistMember);
		}
		return result;
	}
	
	@PostMapping("/member/duplicate")
	@ResponseBody
	public Map<String, Object> doMemberDuplicate(@RequestParam String id) {
		Map<String, Object> result = new HashMap<>();
		String duplicateId = memberService.readDuplicateId(id);
		if ( duplicateId == null ) {
			result.put("data", "사용 가능한 아이디 입니다.");
			result.put("possible", true);
		}
		else {
			result.put("data", "중복된 아이디가 존재합니다. 다른 아이디를 사용해주세요");
			result.put("possible", false);
		}
		return result;
	}
	
	@GetMapping("/member/login")
	public String viewLoginPage() {
		return "member/login";
	}

}
