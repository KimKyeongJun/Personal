package com.ktds.showing.list.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.showing.list.vo.ShowingListVO;

@Repository
public class ShowingListDaoImpl extends SqlSessionDaoSupport implements ShowingListDao {
	
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertOneShowingList(ShowingListVO showingListVO) {
		return getSqlSession().insert("ShowingListDao.insertOneShowingList", showingListVO);
	}
}
