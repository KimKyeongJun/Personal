package com.ktds.ticketing.biz;

import java.util.List;

import com.ktds.ticketing.vo.TicketingVO;

public interface TicketingBiz {
	
	public boolean createOneTicketing(TicketingVO ticketingVO);
	
	public List<String> readTicketingSeatList(String showingId);
	
	public int readCountByReservationId(String reservationId);
	
	public List<TicketingVO> readAllTicketingByReservationId(String reservationId);

}
