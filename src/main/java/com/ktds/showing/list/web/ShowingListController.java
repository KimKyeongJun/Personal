package com.ktds.showing.list.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.reservation.vo.ReservationVO;
import com.ktds.showing.list.service.ShowingListService;
import com.ktds.showing.list.vo.ShowingListVO;

@Controller
public class ShowingListController {
	
	@Autowired
	private ShowingListService showingListService;
	
	@PostMapping("/movie/regist")
	@ResponseBody
	public Map<String, Object> doRegistOneShowingListAction(@ModelAttribute ShowingListVO showingListVO) {
		Map<String, Object> result = new HashMap<>();
		boolean isRegist = this.showingListService.registOneShowingList(showingListVO);
		result.put("status", isRegist);
		return result;
	}
	
	@GetMapping("/movie/showinglist")
	public ModelAndView viewShowingListPage(@RequestParam(required=false) String movieCode) {
		System.out.println("QQQ"+movieCode);
		List<ShowingListVO> showingList = this.showingListService.readAllShowingList(movieCode);
		ModelAndView view = new ModelAndView("movie/showinglist");
		view.addObject("showingList", showingList);
		return view;
	}
	
	@GetMapping("/reserve/confirm")
	public ModelAndView viewReservationConfirmPage(@ModelAttribute ReservationVO reservationVO) {
		ShowingListVO showingListVO = this.showingListService.readOneShowingList(reservationVO.getShowingId());
		System.out.println("ReservationController " + showingListVO.getMovieVO().getMovieName());
		System.out.println("!!!ReservationController" + reservationVO.getShowingId());
		ModelAndView view = new ModelAndView("reservation/confirm");
		view.addObject("showingListVO", showingListVO);
		return view;
	}

}
