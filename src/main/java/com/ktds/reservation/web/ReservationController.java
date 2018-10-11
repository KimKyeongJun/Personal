package com.ktds.reservation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.showing.seat.service.ShowingSeatService;
import com.ktds.showing.seat.vo.ShowingSeatVO;

@Controller
public class ReservationController {
	
	@Autowired
	private ShowingSeatService showingSeatService;
	
	@GetMapping("/reserve/showingseat")
	public ModelAndView viewReservationPage(@RequestParam String movieCode, @RequestParam String startDate, @RequestParam int showingNum) {
		ModelAndView view = new ModelAndView("showingseat/showingseat");
		List<ShowingSeatVO> showingSeat = this.showingSeatService.readAllSeat(showingNum);
		view.addObject("showingSeat", showingSeat);
		return view;
	}

}
