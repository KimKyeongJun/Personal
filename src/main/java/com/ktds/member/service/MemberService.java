package com.ktds.member.service;

import com.ktds.member.vo.MemberVO;

public interface MemberService {
	
	public boolean createMember(MemberVO memberVO);
	
	public String readDuplicateId(String id);
	
	public boolean readOneMember(MemberVO memberVO);

}
