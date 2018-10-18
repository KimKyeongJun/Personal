package com.ktds.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.common.util.SHA256Util;
import com.ktds.member.biz.MemberBiz;
import com.ktds.member.vo.MemberVO;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberBiz memberBiz;

	@Override
	public boolean createMember(MemberVO memberVO) {
		return this.memberBiz.createMember(memberVO);
	}
	
	public String getHashedPassword(String salt, String password) {
		return SHA256Util.getEncrypt(password, salt);
	}
	
	@Override
	public String readDuplicateId(String id) {
		return this.memberBiz.readDuplicateId(id);
	}
	
	@Override
	public boolean readOneMember(MemberVO memberVO) {
		return this.memberBiz.readOneMember(memberVO);
	}
	
	@Override
	public boolean readOneMember(MemberVO memberVO, HttpSession session) {
		return this.memberBiz.readOneMember(memberVO, session);
	}
	
	@Override
	public boolean isBlockUser(String id) {
		return this.memberBiz.isBlockUser(id);
	}
	@Override
	public boolean increaseLoginFailCount(String id) {
		return this.memberBiz.increaseLoginFailCount(id);
	}
	@Override
	public boolean unBlockUser(String id) {
		return this.memberBiz.unBlockUser(id);
	}
	
	@Override
	public String findMemberId(MemberVO memberVO) {
		return this.memberBiz.findMemberId(memberVO);
	}
	
	@Override
	public String readOneMemberIsAdmin(String id) {
		return this.memberBiz.readOneMemberIsAdmin(id);
	}
	
	@Override
	public boolean readOneGuestUser(MemberVO memberVO) {
		return this.memberBiz.readOneGuestUser(memberVO);
	}
	
	@Override
	public boolean readOneMemberForModify(MemberVO memberVO) {
		return this.memberBiz.readOneMemberForModify(memberVO);
	}
	
	@Override
	public boolean updateOneMember(MemberVO memberVO) {
		return this.memberBiz.updateOneMember(memberVO);
	}
}
