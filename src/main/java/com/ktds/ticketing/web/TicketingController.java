package com.ktds.ticketing.web;

import java.util.Map;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ticketing.service.TicketingService;

@Controller
public class TicketingController {
	
	@Autowired
	private TicketingService ticketingService;
	
	@GetMapping("/reserve/showingseat")
	public ModelAndView viewReservationPage(@RequestParam String movieCode, @RequestParam String showingId, @RequestParam int showingNum) {
		ModelAndView view = new ModelAndView("showingseat/showingseat");
		
		System.out.println("TicketingController!!!");
		
		Map<String, Object> seatList = this.ticketingService.readTicketingSeatList(showingId, showingNum);
		System.out.println("TicketingController!" + seatList.get("showingSeat"));
		System.out.println("TicketingController!!" + seatList.get("ticketingSeatList"));
		view.addObject("showingSeat", seatList.get("showingSeat"));
		view.addObject("reservationSeatList", seatList.get("ticketingSeatList"));
		view.addObject("showingId",showingId);
		view.addObject("showingNum",showingNum);
		
		
		return view;
	}

}
