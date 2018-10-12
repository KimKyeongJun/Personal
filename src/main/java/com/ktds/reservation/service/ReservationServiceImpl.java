package com.ktds.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.reservation.biz.ReservationBiz;
import com.ktds.reservation.vo.ReservationVO;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationBiz reserveBiz;
	
	@Override
	public boolean registOneReservation(ReservationVO reservationVO) {
		return this.reserveBiz.registOneReservation(reservationVO);
	}
	

}
