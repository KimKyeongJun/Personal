package com.ktds.reservation.biz;

import java.util.List;

import com.ktds.member.vo.MemberVO;
import com.ktds.reservation.vo.ReservationVO;

public interface ReservationBiz {
	
	public boolean registOneReservation(ReservationVO reservationVO);
	
	public List<String> readReservationSeatList(String showingId);
	
	public List<ReservationVO> readAllReservationList(MemberVO memberVO);
	
	public ReservationVO readOneReservation(String reservationId);

}
