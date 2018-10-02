package com.ktds.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.ktds.member.service.MemberService;
import com.ktds.member.vo.MemberVO;

public class UserService implements AuthenticationProvider {

	@Autowired
	public MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	//memberlogin이 호출 되었을 때
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String userId = authentication.getPrincipal().toString();			// 사용자가 입력한 아이디
		String userPassword = authentication.getCredentials().toString();	// 사용자가 입력한 패스워드

		MemberVO loginMemberVO = new MemberVO();
		loginMemberVO.setId(userId);
		loginMemberVO.setPassword(userPassword);

		boolean isBlockAccount = memberService.isBlockUser(loginMemberVO.getId());
		boolean isLoginSuccess = false;
		String isAdmin = null;
		// 로그인 횟수 제한 방어코드 작성
		if (!isBlockAccount) {
			isLoginSuccess = memberService.readOneMember(loginMemberVO);

			if (!isLoginSuccess) {
				this.memberService.increaseLoginFailCount(loginMemberVO.getId());
				isAdmin = this.memberService.readOneMemberIsAdmin(loginMemberVO.getId());
			} else {
				this.memberService.unBlockUser(loginMemberVO.getId());
			}
		}
		
		UsernamePasswordAuthenticationToken result = null;

		// Token 값 생성 및 등록 코드 작성
		if (isLoginSuccess) {
			String token = UUID.randomUUID().toString();
			String grade= "ROLE_USER";
			
			if ( isAdmin.equals("Y") ){
				grade = "ROLE_ADMIN";
			}
			
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority(grade));
			
			if ( grade.equals("ROLE_ADMIN")){
				roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			}
			result = new UsernamePasswordAuthenticationToken(userId, userPassword, roles);
			
			User user = new User(userId, userPassword, grade, isBlockAccount, token);
			result.setDetails(user);
		}
		else {
			throw new BadCredentialsException("잘못된 인증");
		}
		
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
