package com.ktds.member.biz;

import javax.servlet.http.HttpSession;

import com.ktds.member.vo.MemberVO;

public interface MemberBiz {

	public boolean createMember(MemberVO memberVO);

	public String readDuplicateId(String id);

	public boolean readOneMember(MemberVO memberVO);

	public boolean readOneMember(MemberVO memberVO, HttpSession session);

	public boolean isBlockUser(String id);
	
	public boolean unBlockUser(String id);
	
	public boolean increaseLoginFailCount(String id);
	
	public String findMemberId(MemberVO memberVO);
	
	public String readOneMemberIsAdmin(String id);
	
	public boolean updateOneMemberById(String id, int mileage);

}
