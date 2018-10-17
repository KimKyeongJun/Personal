package com.ktds.showing.list.dao;

import java.util.List;
import java.util.Map;

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
	
	@Override
	public String selectEndTimeOfDay(Map<String, String> param) {
		return getSqlSession().selectOne("ShowingListDao.selectEndTimeOfDay", param);
	}
	
	@Override
	public int selectStartDateTimeMovie(ShowingListVO showingListVO) {
		System.out.println("Dao 출력 " + getSqlSession().selectOne("ShowingListDao.selectStartDateTimeMovie", showingListVO));
		return getSqlSession().selectOne("ShowingListDao.selectStartDateTimeMovie", showingListVO);
	}
	
	@Override
	public List<ShowingListVO> selectAllShowingList(String movieCode) {
		return getSqlSession().selectList("ShowingListDao.selectAllShowingList", movieCode);
	}
	
	@Override
	public ShowingListVO selectOneShowingList(String showingId) {
		return getSqlSession().selectOne("ShowingListDao.selectOneShowingList", showingId);
	}
}
