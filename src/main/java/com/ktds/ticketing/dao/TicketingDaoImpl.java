package com.ktds.ticketing.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.ticketing.vo.TicketingVO;

@Repository
public class TicketingDaoImpl extends SqlSessionDaoSupport implements TicketingDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertOneTicketing(TicketingVO ticketingVO) {
		return getSqlSession().insert("TicketingDao.insertOneTicketing", ticketingVO);
	}
	
	@Override
	public List<String> selectTicketingSeatList(String showingId) {
		return getSqlSession().selectList("TicketingDao.selectTicketingSeatList", showingId);
	}
	
	@Override
	public int selectCountByReservationId(String reservationId) {
		return getSqlSession().selectOne("TicketingDao.selectCountByReservationId", reservationId);
	}
	
	@Override
	public List<TicketingVO> selectAllTicketingByReservationId(String reservatonId) {
		return getSqlSession().selectList("TicketingDao.selectAllTicketingByReservationId", reservatonId);
	}

}
