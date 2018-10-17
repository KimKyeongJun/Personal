package com.ktds.reservation.dao;

import java.util.List;

import com.ktds.member.vo.MemberVO;
import com.ktds.reservation.vo.ReservationVO;

public interface ReservationDao {
	
	public int insertOneReservation(ReservationVO reservationVO);
	
	public List<String> selectReservationSeatList(String showingId);
	
	public List<ReservationVO> selectAllReservationList(MemberVO memberVO);
	
	public ReservationVO selectOneReservation(String reservationId);
	

}
