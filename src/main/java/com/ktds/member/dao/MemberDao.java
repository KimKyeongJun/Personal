package com.ktds.member.dao;

import java.util.Map;

import com.ktds.member.vo.MemberVO;

public interface MemberDao {
	
	public int insertMember(MemberVO memberVO);
	
	public String selectDuplicateId(String id);
	
	public MemberVO selectOneMember(MemberVO memberVO);
	
	public int updateLoginFailCount(String id);
	
	public String selectOneSaltById(String id);
	
	public int unBlockUser(String id);
	
	public Integer isBlockUser(String id);
	
	public String selectOneMemberId(MemberVO memberVO);
	
	public String selectOneMemberIsAdmin(String id);
	
	public int updateOneMemberById(Map<String, Object> param);
	
	public int selectOneGuestUser(MemberVO memberVO);

}
