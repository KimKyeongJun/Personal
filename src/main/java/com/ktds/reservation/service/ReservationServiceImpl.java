package com.ktds.reservation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.member.biz.MemberBiz;
import com.ktds.member.vo.MemberVO;
import com.ktds.reservation.biz.ReservationBiz;
import com.ktds.reservation.vo.ReservationVO;
import com.ktds.showing.seat.biz.ShowingSeatBiz;
import com.ktds.showing.seat.vo.ShowingSeatVO;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationBiz reservationBiz;
	
	@Autowired
	private ShowingSeatBiz showingSeatBiz;
	
	@Autowired
	private MemberBiz memberBiz;
	
	@Override
	public boolean registOneReservation(ReservationVO reservationVO, HttpSession session) {
		return this.reservationBiz.registOneReservation(reservationVO);
	}
	
	@Override
	public Map<String, Object> readReservationSeatList(int showingNum, String showingId) {
		List<String> reservationSeatList = this.reservationBiz.readReservationSeatList(showingId);
		
		List<ShowingSeatVO> showingSeatList = this.showingSeatBiz.readAllSeat(showingNum);
		
		Map<String, Object> result = new HashMap<>();
		result.put("showingSeat", showingSeatList);
		result.put("reservationSeatList", reservationSeatList);
		return result;
	}
	
	@Override
	public List<ReservationVO> readAllReservationList(MemberVO memberVO) {
		return this.reservationBiz.readAllReservationList(memberVO);
	}
	
	@Override
	public ReservationVO readOneReservation(String reservationId) {
		return this.reservationBiz.readOneReservation(reservationId);
	}
	

}
