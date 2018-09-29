package com.ktds.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.common.util.SHA256Util;
import com.ktds.member.dao.MemberDao;
import com.ktds.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean createMember(MemberVO memberVO) {
		String salt = SHA256Util.generateSalt();
		String password = this.getHashedPassword(salt, memberVO.getPassword());
		
		memberVO.setPassword(password);
		memberVO.setSalt(salt);		
		return this.memberDao.insertMember(memberVO) > 0;
	}
	
	public String getHashedPassword(String salt, String password) {
		return SHA256Util.getEncrypt(password, salt);
	}
	
	@Override
	public String readDuplicateId(String id) {
		return this.memberDao.selectDuplicateId(id);
	}
	
	@Override
	public boolean readOneMember(MemberVO memberVO) {
		String salt = memberDao.selectOneSaltById(memberVO.getId());
		String password = this.getHashedPassword(salt, memberVO.getPassword());
		
		memberVO.setPassword(password);
		MemberVO loginMemberVO = memberDao.selectOneMember(memberVO);
		
		if ( loginMemberVO != null ) {
			memberDao.unBlockUser(loginMemberVO.getId());
			return true;
		}
		else {
			memberDao.updateLoginFailCount(memberVO);
			return false;			
		}
	}
	
	@Override
	public boolean isBlockUser(String id) {
		Integer isBlockUser = memberDao.isBlockUser(id);
		
		if ( isBlockUser == null) {
			isBlockUser = 0;
		}
		
		return isBlockUser >= 3;
	}
	
	@Override
	public String findMemberId(MemberVO memberVO) {
		return this.memberDao.selectOneMemberId(memberVO);
	}
}
