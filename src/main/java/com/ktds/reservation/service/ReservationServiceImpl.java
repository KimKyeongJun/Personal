package com.ktds.reservation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.member.vo.MemberVO;
import com.ktds.reservation.biz.ReservationBiz;
import com.ktds.reservation.vo.ReservationVO;
import com.ktds.showing.seat.biz.ShowingSeatBiz;
import com.ktds.showing.seat.vo.ShowingSeatVO;
import com.ktds.ticketing.biz.TicketingBiz;
import com.ktds.ticketing.vo.TicketingVO;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationBiz reservationBiz;
	
	@Autowired
	private ShowingSeatBiz showingSeatBiz;
	
	@Autowired
	private TicketingBiz ticketingBiz;
	
	@Override
	public boolean registOneReservation(ReservationVO reservationVO, HttpSession session) {
		boolean isRegist = this.reservationBiz.registOneReservation(reservationVO);
		for ( String seatNumber : reservationVO.getSeatNumberList() ) {
			TicketingVO ticketingVO = new TicketingVO();
			ticketingVO.setSeatNumber(seatNumber);
			ticketingVO.setShowingNum(reservationVO.getShowingNum());
			this.ticketingBiz.createOneTicketing(ticketingVO);
		}
		return isRegist;
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
		List<ReservationVO> reservationList = this.reservationBiz.readAllReservationList(memberVO);
		
		for (ReservationVO reservationVO : reservationList) {
			int ticketCount = this.ticketingBiz.readCountByReservationId(reservationVO.getReservationId());
			reservationVO.setTicketCount(ticketCount);
		}
		return reservationList;
	}
	
	@Override
	public ReservationVO readOneReservation(String reservationId) {
		return this.reservationBiz.readOneReservation(reservationId);
	}
	

}
