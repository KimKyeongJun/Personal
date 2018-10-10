package com.ktds.showing.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.showing.vo.ShowingVO;

@Repository
public class ShowingDaoImpl extends SqlSessionDaoSupport implements ShowingDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public List<Integer> selectAllShowings() {
		return getSqlSession().selectList("ShowingDao.selectAllShowings");
	}
	
}
