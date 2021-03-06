package com.ktds.member.service;

import javax.servlet.http.HttpSession;

import com.ktds.member.vo.MemberVO;

public interface MemberService {
	
	public boolean createMember(MemberVO memberVO);
	
	public String readDuplicateId(String id);
	
	public boolean readOneMember(MemberVO memberVO);
	
	public boolean readOneMember(MemberVO memberVO, HttpSession session);
	
	public boolean isBlockUser(String id);
	
	
	public boolean unBlockUser(String id);
	
	public boolean increaseLoginFailCount(String id);
	
	public String findMemberId(MemberVO memberVO);
	
	public String readOneMemberIsAdmin(String id);
	
	public boolean readOneGuestUser(MemberVO memberVO);
	
	public boolean readOneMemberForModify(MemberVO memberVO);
	
	public boolean updateOneMember(MemberVO memberVO);

}
