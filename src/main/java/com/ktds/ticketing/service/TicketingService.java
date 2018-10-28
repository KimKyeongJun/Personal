package com.ktds.ticketing.service;

import java.util.Map;

import com.ktds.ticketing.vo.TicketingVO;

public interface TicketingService {
	
	public boolean createOneTicketing(TicketingVO ticketingVO);
	
	public Map<String, Object> readTicketingSeatList(String showingId, int showingNum);
	
	public Map<String, Object> readAllTicketingByReservationId(String reservationId);

}
