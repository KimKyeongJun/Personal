package com.ktds.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.common.KafkaLogger;
import com.ktds.common.session.Session;
import com.ktds.member.vo.MemberVO;

public class LogInterceptor extends HandlerInterceptorAdapter {
	
	private KafkaLogger qosLogger = new KafkaLogger();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		MemberVO loginMemberVO = (MemberVO)session.getAttribute(Session.USER);
		
		if ( loginMemberVO != null ) {
			qosLogger.info("#"+request.getRemoteAddr() + "#" +loginMemberVO.getId() +"#"+ request.getRequestURI() + "#"+request.getMethod());
		}
		else {			
			qosLogger.info("#"+request.getRemoteAddr() + "##"+ request.getRequestURI() + "#"+request.getMethod());
		}
		return true;
	}
	
}
