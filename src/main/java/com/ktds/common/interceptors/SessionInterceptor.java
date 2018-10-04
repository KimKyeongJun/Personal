package com.ktds.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.common.session.Session;
import com.ktds.member.dao.MemberDao;
import com.ktds.member.vo.MemberVO;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
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
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		MemberVO loginMemberVO = (MemberVO) session.getAttribute(Session.USER);
		
		if ( loginMemberVO != null ) {
			MemberVO newMemberVO = this.memberDao.selectOneMember(loginMemberVO);
			session.setAttribute(Session.USER, newMemberVO);
		}
	}
}
