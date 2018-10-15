package com.ktds.reservation.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ktds.reservation.vo.ReservationVO;

public interface ReservationService {
	
	public boolean registOneReservation(ReservationVO reservationVO, HttpSession session);
	
	public Map<String, Object> readReservationSeatList(int showingNum, String showingId);

}
