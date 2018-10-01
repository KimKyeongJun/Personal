package com.ktds.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.common.session.Session;
import com.ktds.member.vo.MemberVO;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		MemberVO member = (MemberVO)session.getAttribute(Session.USER);
		MemberVO guest = (MemberVO)session.getAttribute(Session.GUEST);
		
		if ( member == null && guest == null ) {
			response.sendRedirect("/PersonalProject/member/login");
			return false;
		}
		
		return true;
	}
}
