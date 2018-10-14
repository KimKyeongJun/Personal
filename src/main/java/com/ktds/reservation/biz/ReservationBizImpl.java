package com.ktds.reservation.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.reservation.dao.ReservationDao;
import com.ktds.reservation.vo.ReservationVO;

@Component
public class ReservationBizImpl implements ReservationBiz {
	
	@Autowired
	private ReservationDao reservationDao;	
	
	@Override
	public boolean registOneReservation(ReservationVO reservationVO) {
		
		for ( String seatNumber : reservationVO.getSeatNumberList() ) {
			reservationVO.setSeatNumber(seatNumber);
			this.reservationDao.insertOneReservation(reservationVO);
		}
		return true;
	}
	
	@Override
	public List<String> readReservationSeatList(String showingId) {
		return this.reservationDao.selectReservationSeatList(showingId);
	}

}
