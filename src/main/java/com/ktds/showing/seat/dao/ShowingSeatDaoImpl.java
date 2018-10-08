package com.ktds.showing.seat.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.showing.seat.vo.ShowingSeatVO;


@Repository
public class ShowingSeatDaoImpl extends SqlSessionDaoSupport implements ShowingSeatDao {

	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public List<ShowingSeatVO> selectAllSeat(int showingNum) {
		return getSqlSession().selectList("ShowingSeatDao.selectAllSeat", showingNum);
	}
}
