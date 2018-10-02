package com.ktds.member.biz;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.common.session.Session;
import com.ktds.common.util.SHA256Util;
import com.ktds.member.dao.MemberDao;
import com.ktds.member.vo.LoginVO;
import com.ktds.member.vo.MemberVO;

@Component
public class MemberBizImpl implements MemberBiz {

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

		if (loginMemberVO != null) {
			memberDao.unBlockUser(loginMemberVO.getId());
			return true;
		} else {
			memberDao.updateLoginFailCount(memberVO.getId());
			return false;
		}
	}

	@Override
	public boolean readOneMember(MemberVO memberVO, HttpSession session) {
		String salt = memberDao.selectOneSaltById(memberVO.getId());
		String password = this.getHashedPassword(salt, memberVO.getPassword());

		memberVO.setPassword(password);
		MemberVO loginMemberVO = memberDao.selectOneMember(memberVO);

		if (loginMemberVO != null) {
			session.setAttribute(Session.USER, loginMemberVO);
			memberDao.unBlockUser(loginMemberVO.getId());
			return true;
		} 
		else {
			memberDao.updateLoginFailCount(memberVO.getId());
			return false;
		}
	}

	@Override
	public boolean isBlockUser(String id) {
		Integer isBlockUser = memberDao.isBlockUser(id);

		if (isBlockUser == null) {
			isBlockUser = 0;
		}
		System.out.println("출력" + isBlockUser);
		return isBlockUser >= 3;
	}
	
	@Override
	public boolean increaseLoginFailCount(String id) {
		return this.memberDao.updateLoginFailCount(id) > 0;
	}
	
	@Override
	public boolean unBlockUser(String id) {
		return this.memberDao.unBlockUser(id) > 0;
	}

	@Override
	public String findMemberId(MemberVO memberVO) {
		return this.memberDao.selectOneMemberId(memberVO);
	}
	
	@Override
	public String readOneMemberIsAdmin(String id) {
		return this.memberDao.selectOneMemberIsAdmin(id);
	}
}
