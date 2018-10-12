package com.ktds.reservation.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
