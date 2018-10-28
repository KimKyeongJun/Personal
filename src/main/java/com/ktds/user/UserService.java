package com.ktds.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.ktds.member.service.MemberService;
import com.ktds.member.vo.MemberVO;

@Component("userService")
public class UserService implements AuthenticationProvider {
	
	public UserService() {
	}
	
	@Autowired
	public MemberService memberService;
	
	//memberlogin이 호출 되었을 때
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String userId = authentication.getPrincipal().toString();			// 사용자가 입력한 아이디
		String userPassword = authentication.getCredentials().toString();	// 사용자가 입력한 패스워드

		MemberVO memberVO = new MemberVO();
		memberVO.setId(userId);
		memberVO.setPassword(userPassword);

		boolean isBlockAccount = this.memberService.isBlockUser(memberVO.getId());
		boolean isLoginSuccess = false;
		// 로그인 횟수 제한 방어코드 작성
		if (!isBlockAccount) {
			isLoginSuccess = this.memberService.readOneMember(memberVO);

			/*if (!isLoginSuccess) {
				memberService.increaseLoginFailCount(memberVO.getId());
			} else {
				memberService.unBlockUser(memberVO.getId());
			}*/
		}
		
		UsernamePasswordAuthenticationToken result = null;

		// Token 값 생성 및 등록 코드 작성
		if (isLoginSuccess) {
			String token = UUID.randomUUID().toString();
			String grade= "ROLE_USER";
			String isAdmin = this.memberService.readOneMemberIsAdmin(userId);
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
			//throw new BadCredentialsException("잘못된 인증");
			String grade= "ROLE_USER";
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority(grade));
			result = new UsernamePasswordAuthenticationToken(userId, userPassword, roles);
			User user = new User(userId, userPassword, grade, isBlockAccount, "");
			result.setDetails(user);
			return result;
		}
		
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
