package com.ktds.reservation.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.member.vo.MemberVO;
import com.ktds.reservation.dao.ReservationDao;
import com.ktds.reservation.vo.ReservationVO;

@Component
public class ReservationBizImpl implements ReservationBiz {
	
	@Autowired
	private ReservationDao reservationDao;	
	
	@Override
	public boolean registOneReservation(ReservationVO reservationVO) {
		return this.reservationDao.insertOneReservation(reservationVO) > 0;
	}
	
	@Override
	public List<String> readReservationSeatList(String showingId) {
		return this.reservationDao.selectReservationSeatList(showingId);
	}
	
	@Override
	public List<ReservationVO> readAllReservationList(MemberVO memberVO) {
		return this.reservationDao.selectAllReservationList(memberVO);
	}
	
	@Override
	public ReservationVO readOneReservation(String reservationId) {
		return this.reservationDao.selectOneReservation(reservationId);
	}

}
