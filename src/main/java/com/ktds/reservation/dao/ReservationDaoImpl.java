package com.ktds.reservation.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.member.vo.MemberVO;
import com.ktds.reservation.vo.ReservationVO;

@Repository
public class ReservationDaoImpl extends SqlSessionDaoSupport implements ReservationDao {
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertOneReservation(ReservationVO reservationVO) {
		return getSqlSession().insert("ReservationDao.insertOneReservation", reservationVO);
	}
	
	@Override
	public List<String> selectReservationSeatList(String showingId) {
		return getSqlSession().selectList("ReservationDao.selectReservationSeatList", showingId);
	}
	
	@Override
	public List<ReservationVO> selectAllReservationList(MemberVO memberVO) {
		return getSqlSession().selectList("ReservationDao.selectAllReservationList", memberVO);
	}
	
	@Override
	public ReservationVO selectOneReservation(String reservationId) {
		return getSqlSession().selectOne("ReservationDao.selectOneReservation", reservationId);
	}

}
