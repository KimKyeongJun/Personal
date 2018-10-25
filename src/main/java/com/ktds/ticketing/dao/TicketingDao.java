package com.ktds.ticketing.dao;

import java.util.List;

import com.ktds.ticketing.vo.TicketingVO;

public interface TicketingDao {
	
	public int insertOneTicketing(TicketingVO ticketingVO);
	
	public List<String> selectTicketingSeatList(String showingId);

}
