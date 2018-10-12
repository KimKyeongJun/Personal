package com.ktds.reservation.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.common.session.Session;
import com.ktds.member.vo.MemberVO;
import com.ktds.reservation.service.ReservationService;
import com.ktds.reservation.vo.ReservationVO;
import com.ktds.showing.seat.service.ShowingSeatService;
import com.ktds.showing.seat.vo.ShowingSeatVO;

@Controller
public class ReservationController {
	
	@Autowired
	private ShowingSeatService showingSeatService;
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/reserve/showingseat")
	public ModelAndView viewReservationPage(@RequestParam String movieCode, @RequestParam String showingId, @RequestParam int showingNum) {
		ModelAndView view = new ModelAndView("showingseat/showingseat");
		List<ShowingSeatVO> showingSeat = this.showingSeatService.readAllSeat(showingNum);
		view.addObject("showingSeat", showingSeat);
		view.addObject("showingId",showingId);
		view.addObject("showingNum",showingNum);
		return view;
	}
	
	@PostMapping("/reserve")
	@ResponseBody
	public Map<String, Object> doMovieRegistAction(@ModelAttribute ReservationVO reservationVO, HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		
		MemberVO userMemberVO = (MemberVO) session.getAttribute(Session.USER);
		MemberVO guestMemberVO = (MemberVO) session.getAttribute(Session.GUEST);
		
		if ( userMemberVO != null ) {
			reservationVO.setId(userMemberVO.getId());
		}
		else {
			reservationVO.setName(guestMemberVO.getName());
			reservationVO.setPhone(guestMemberVO.getPhone());
		}
		
		boolean isRegist = reservationService.registOneReservation(reservationVO);
		result.put("status", isRegist);
		return result;
	}

}
