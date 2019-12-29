package com.ktds.showing.seat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.showing.seat.service.ShowingSeatService;

@Controller
public class ShowingSeatController {
	
	@Autowired
	private ShowingSeatService showingSeatService;
	
	@GetMapping("/showingseat")
	public ModelAndView viewShowingSeatPage(@RequestParam int showingNum) {
		ModelAndView view = new ModelAndView("showingseat/showingseat");
		
		
		view.addObject("showingSeat", this.showingSeatService.readAllSeat(showingNum));
		return view;
	}
	
}
