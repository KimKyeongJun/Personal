package com.ktds.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.member.vo.MemberVO;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {
	
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		return getSqlSession().insert("MemberDao.insertMember", memberVO);
	}
	
	@Override
	public String selectDuplicateId(String id) {
		return getSqlSession().selectOne("MemberDao.selectDuplicateId", id);
	}
	
	@Override
	public MemberVO selectOneMember(MemberVO memberVO) {
		return getSqlSession().selectOne("MemberDao.selectOneMember", memberVO);
	}
	
	@Override
	public int updateLoginFailCount(String id) {
		return getSqlSession().update("MemberDao.updateLoginFailCount", id);
	}
	
	@Override
	public String selectOneSaltById(String id) {
		return getSqlSession().selectOne("MemberDao.selectOneSaltById", id);
	}
	
	@Override
	public int unBlockUser(String id) {
		return getSqlSession().update("MemberDao.unBlockUser", id);
	}
	
	@Override
	public Integer isBlockUser(String id) {
		return getSqlSession().selectOne("MemberDao.isBlockUser", id);
	}
	
	@Override
	public String selectOneMemberId(MemberVO memberVO) {
		return getSqlSession().selectOne("MemberDao.selectOneMemberId", memberVO);
	}
	
	@Override
	public String selectOneMemberIsAdmin(String id) {
		return getSqlSession().selectOne("MemberDao.selectOneMemberIsAdmin", id);
	}
	
	@Override
	public int updateOneMemberById(Map<String, Object> param) {
		return getSqlSession().insert("MemberDao.updateOneMemberById", param);
	}
	
	@Override
	public int selectOneGuestUser(MemberVO memberVO) {
		return getSqlSession().selectOne("MemberDao.selectOneGuestUser", memberVO);
	}

}
