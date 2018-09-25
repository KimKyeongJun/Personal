package com.ktds.member.dao;

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
	public int updateLoginFailCount(MemberVO memberVO) {
		return getSqlSession().update("MemberDao.updateLoginFailCount", memberVO);
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

}
