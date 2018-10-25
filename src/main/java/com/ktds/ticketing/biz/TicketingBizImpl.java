package com.ktds.ticketing.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.ticketing.dao.TicketingDao;
import com.ktds.ticketing.vo.TicketingVO;

@Component
public class TicketingBizImpl implements TicketingBiz{

	@Autowired 
	private TicketingDao ticketingDao;

	@Override
	public boolean createOneTicketing(TicketingVO ticketingVO) {
		return this.ticketingDao.insertOneTicketing(ticketingVO) > 0;
	}

	@Override
	public List<String> readTicketingSeatList(String showingId) {
		return this.ticketingDao.selectTicketingSeatList(showingId);
	}
	
	
	
	
}
