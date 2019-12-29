package com.ktds.reservation.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.common.session.Session;
import com.ktds.member.vo.MemberVO;
import com.ktds.reservation.service.ReservationService;
import com.ktds.reservation.vo.ReservationVO;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	/*
	@GetMapping("/reserve/showingseat")
	public ModelAndView viewReservationPage(@RequestParam String movieCode, @RequestParam String showingId, @RequestParam int showingNum) {
		ModelAndView view = new ModelAndView("showingseat/showingseat");
		
		Map<String, Object> seatList = this.reservationService.readReservationSeatList(showingNum, showingId);
		view.addObject("showingSeat", seatList.get("showingSeat"));
		view.addObject("reservationSeatList", seatList.get("reservationSeatList"));
		view.addObject("showingId",showingId);
		view.addObject("showingNum",showingNum);
		
		
		return view;
	}*/
	
	@PostMapping("/reserve")
	@ResponseBody
	public boolean doMovieRegistAction(@ModelAttribute ReservationVO reservationVO, HttpSession session) {
		
		MemberVO userMemberVO = (MemberVO) session.getAttribute(Session.USER);
		MemberVO guestMemberVO = (MemberVO) session.getAttribute(Session.GUEST);
		
		if ( userMemberVO != null ) {
			reservationVO.setId(userMemberVO.getId());
		}
		else {
			reservationVO.setName(guestMemberVO.getName());
			reservationVO.setPhone(guestMemberVO.getPhone());
		}		
		
		return reservationService.registOneReservation(reservationVO,session);
	}
	
	@GetMapping("/reserve/result")
	public String viewReservationResultPage() {
		return "reservation/reservationresult";
	}
	
	@GetMapping("/reserve/inquiry")
	public ModelAndView viewReservationInquiryPage (HttpSession session) {
		ModelAndView view = new ModelAndView("reservation/inquiry");
		
		MemberVO userMemberVO = (MemberVO)session.getAttribute(Session.USER);
		MemberVO guestMemberVO = (MemberVO)session.getAttribute(Session.GUEST);
		
		if ( userMemberVO != null ) {
			List<ReservationVO> reservationList  = this.reservationService.readAllReservationList(userMemberVO);
			view.addObject("reservationList",reservationList);
		}
		else {
			List<ReservationVO> reservationList = this.reservationService.readAllReservationList(guestMemberVO);
			view.addObject("reservationList", reservationList);
		}
		return view;
	}

}
