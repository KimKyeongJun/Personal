package com.ktds.showing.seat.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.showing.seat.service.ShowingSeatService;
import com.ktds.showing.seat.vo.ShowingSeatVO;

@Controller
public class ShowingSeatController {
	
	@Autowired
	private ShowingSeatService showingSeatService;
	
	@GetMapping("/showingseat")
	public ModelAndView viewShowingSeatPage(@RequestParam int showingNum) {
		ModelAndView view = new ModelAndView("showingseat/showingseat");
		List<ShowingSeatVO> seatList = this.showingSeatService.readAllSeat(showingNum);
		
		for (ShowingSeatVO showingSeatVO : seatList ) {
			System.out.println(showingSeatVO.getShowingNum()+"상영관"+showingSeatVO.getSeatNumber());
		}
		view.addObject("showingSeat", this.showingSeatService.readAllSeat(showingNum));
		return view;
	}
	
}
