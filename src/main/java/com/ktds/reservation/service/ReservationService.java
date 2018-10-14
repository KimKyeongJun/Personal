package com.ktds.reservation.service;

import java.util.Map;

import com.ktds.reservation.vo.ReservationVO;

public interface ReservationService {
	
	public boolean registOneReservation(ReservationVO reservationVO);
	
	public Map<String, Object> readReservationSeatList(int showingNum, String showingId);

}
