package com.ktds.ticketing.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ticketing.service.TicketingService;

@Controller
public class TicketingController {
	@Autowired
	private TicketingService ticketingService;
	
	Logger logger = LoggerFactory.getLogger(TicketingController.class);
	
	@GetMapping("/reserve/showingseat")
	public ModelAndView viewReservationPage(@RequestParam String movieCode, @RequestParam String showingId, @RequestParam int showingNum) {
		ModelAndView view = new ModelAndView("showingseat/showingseat");
		
		logger.info("{}", "ticketingController");
		
		Map<String, Object> seatList = this.ticketingService.readTicketingSeatList(showingId, showingNum);
		view.addObject("showingSeat", seatList.get("showingSeat"));
		view.addObject("reservationSeatList", seatList.get("ticketingSeatList"));
		view.addObject("showingId",showingId);
		view.addObject("showingNum",showingNum);
		
		
		return view;
	}
	
	@GetMapping("/reserve/detail/{reservationId}")
	public ModelAndView viewReservationDetailPage(@PathVariable String reservationId) {
		ModelAndView view  = new ModelAndView("reservation/detail");
		Map<String, Object> ticketMap = this.ticketingService.readAllTicketingByReservationId(reservationId);
		view.addObject("ticketList", ticketMap.get("ticketList"));
		view.addObject("reservationVO", ticketMap.get("reservationVO"));		
		return view;
	}

}
