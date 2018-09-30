package com.ktds.member.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.member.service.MemberService;
import com.ktds.member.validator.MemberValidator;
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
	public Map<String, Object> doMemberRegistAction (@Validated({MemberValidator.MemberRegist.class}) @ModelAttribute MemberVO memberVO, Errors errors) {
		Map<String, Object> result = new HashMap<>();
		
		if ( errors.hasErrors() ) {
			StringBuilder errorMessage = new StringBuilder();
			for ( FieldError fieldError : errors.getFieldErrors() ) {
				errorMessage.append(fieldError.getDefaultMessage());
				errorMessage.append("\n");
				result.put("message", errorMessage);
			}
			result.put("regist", false);
			return result;
		}
		else {			
			boolean isRegistMember = memberService.createMember(memberVO);
			
			if ( isRegistMember ) {
				result.put("regist",isRegistMember);			
			}
			else {
				result.put("regist", isRegistMember);
			}
			return result;
		}
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
	
	@PostMapping("/member/login")
	@ResponseBody
	public Map<String, Object> doMemberLoginAction(@ModelAttribute MemberVO memberVO, HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		
		if ( memberService.isBlockUser(memberVO.getId()) ) {
			result.put("login", false);
			result.put("message", "비밀번호 3회 오류로 계정이 잠겼습니다. 1시간 후 다시 시도해주세요");
		}
		
		else {
			boolean isLogin = memberService.readOneMember(memberVO,session);
			if ( !isLogin ) {
				result.put("message", "로그인 실패. 아이디와 비밀번호를 확인하세요");
			}
			result.put("login", isLogin);			
		}
		return result;
	}
	
	@GetMapping("/member/findid")
	public String viewFindIdPage() {
		return "member/findid";
	}
	
	@PostMapping("/member/findid")
	@ResponseBody
	public Map<String, Object> doMemberIdFindAction (@ModelAttribute MemberVO memberVO, HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		String findId = this.memberService.findMemberId(memberVO);
		System.out.println("출력: " + findId);
		if ( findId != null ) {
			result.put("exist", true);
			result.put("id", findId);
			session.setAttribute("_FINDID_", findId);
		}
		else {
			result.put("exist",false);
		}
		return result;
	}
	
	@GetMapping("/member/resultfindid")
	public ModelAndView viewFindMemberIdPage(@RequestParam String resultId) {
		ModelAndView view = new ModelAndView("member/resultfindid");
		view.addObject("findId", resultId);
		return view;
	}
	
	@GetMapping("/member/guest")
	public String viewGusetLoginPage() {
		return "member/guest";
	}
	
	@GetMapping("/member/logout")
	public String doMemberLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
