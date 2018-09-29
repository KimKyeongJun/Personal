package com.ktds.member.dao;

import com.ktds.member.vo.MemberVO;

public interface MemberDao {
	
	public int insertMember(MemberVO memberVO);
	
	public String selectDuplicateId(String id);
	
	public MemberVO selectOneMember(MemberVO memberVO);
	
	public int updateLoginFailCount(MemberVO memberVO);
	
	public String selectOneSaltById(String id);
	
	public int unBlockUser(String id);
	
	public Integer isBlockUser(String id);
	
	public String selectOneMemberId(MemberVO memberVO);

}
