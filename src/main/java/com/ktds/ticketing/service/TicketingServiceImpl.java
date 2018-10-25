package com.ktds.ticketing.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.showing.seat.biz.ShowingSeatBiz;
import com.ktds.showing.seat.vo.ShowingSeatVO;
import com.ktds.ticketing.biz.TicketingBiz;
import com.ktds.ticketing.vo.TicketingVO;

@Service
public class TicketingServiceImpl implements TicketingService {

	@Autowired
	private TicketingBiz ticketingBiz;
	
	@Autowired
	private ShowingSeatBiz showingSeatBiz;
	
	@Override
	public boolean createOneTicketing(TicketingVO ticketingVO) {
		return this.ticketingBiz.createOneTicketing(ticketingVO);
	}

	@Override
	public Map<String, Object> readTicketingSeatList(String showingId, int showingNum) {
		List<String> ticketingSeatList = this.ticketingBiz.readTicketingSeatList(showingId);
		
		List<ShowingSeatVO> showingSeatList = this.showingSeatBiz.readAllSeat(showingNum);
		
		Map<String, Object> result = new HashMap<>();
		result.put("showingSeat", showingSeatList);
		result.put("ticketingSeatList", ticketingSeatList);
		return result;
	}
	
	

}
