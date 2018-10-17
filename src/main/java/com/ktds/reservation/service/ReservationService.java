package com.ktds.reservation.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ktds.member.vo.MemberVO;
import com.ktds.reservation.vo.ReservationVO;

public interface ReservationService {
	
	public boolean registOneReservation(ReservationVO reservationVO, HttpSession session);
	
	public Map<String, Object> readReservationSeatList(int showingNum, String showingId);
	
	public List<ReservationVO> readAllReservationList(MemberVO memberVO);
	
	public ReservationVO readOneReservation(String reservationId);

}
