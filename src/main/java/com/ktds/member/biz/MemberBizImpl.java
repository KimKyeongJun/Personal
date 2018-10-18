package com.ktds.member.biz;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.common.session.Session;
import com.ktds.common.util.SHA256Util;
import com.ktds.member.dao.MemberDao;
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
		if ( salt == null ) {
			return false;
		}
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
	public boolean readOneMemberForModify(MemberVO memberVO) {
		String salt = memberDao.selectOneSaltById(memberVO.getId());
		if ( salt == null ) {
			return false;
		}
		String password = this.getHashedPassword(salt, memberVO.getPassword());
		memberVO.setPassword(password);
		
		MemberVO modifyMemberVO = memberDao.selectOneMember(memberVO);
		if ( modifyMemberVO != null ) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean readOneMember(MemberVO memberVO, HttpSession session) {
		String salt = memberDao.selectOneSaltById(memberVO.getId());
		if (salt == null ) {
			return false;
		}
		//여기 수정해야함
		String password = this.getHashedPassword(salt, memberVO.getPassword());

		memberVO.setPassword(password);
		MemberVO loginMemberVO = memberDao.selectOneMember(memberVO);

		if (loginMemberVO != null) {
			session.setAttribute(Session.USER, loginMemberVO);
			//memberDao.unBlockUser(loginMemberVO.getId());
			return true;
		} 
		else {
			//memberDao.updateLoginFailCount(memberVO.getId());
			return false;
		}
	}

	@Override
	public boolean isBlockUser(String id) {
		Integer isBlockUser = memberDao.isBlockUser(id);

		if (isBlockUser == null) {
			isBlockUser = 0;
		}
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
	
	@Override
	public boolean updateOneMemberById(String id, int mileage) {
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		param.put("mileage",mileage);
		return this.memberDao.updateOneMemberById(param) > 0;
	}
	
	@Override
	public boolean readOneGuestUser(MemberVO memberVO) {
		return this.memberDao.selectOneGuestUser(memberVO) == 0 ;
	}
	
	@Override
	public boolean updateOneMember(MemberVO memberVO) {
		if ( memberVO.getPassword() != null && memberVO.getPassword() != "") {
			String salt = SHA256Util.generateSalt();
			String password = this.getHashedPassword(salt, memberVO.getPassword());

			memberVO.setPassword(password);
			memberVO.setSalt(salt);
		}
		return this.memberDao.updateOneMember(memberVO) > 0;
	}
}
