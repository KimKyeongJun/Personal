package com.ktds.reservation.vo;

import com.ktds.member.vo.MemberVO;
import com.ktds.showinglist.vo.ShowingListVO;
import com.ktds.showingseat.vo.ShowingSeatVO;

public class ReservationVO {

	String reservationId;
	String reservationDate;

	MemberVO memberVO;
	ShowingListVO showingListVO;
	ShowingSeatVO showingSeatVO;

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public ShowingListVO getShowingListVO() {
		return showingListVO;
	}

	public void setShowingListVO(ShowingListVO showingListVO) {
		this.showingListVO = showingListVO;
	}

	public ShowingSeatVO getShowingSeatVO() {
		return showingSeatVO;
	}

	public void setShowingSeatVO(ShowingSeatVO showingSeatVO) {
		this.showingSeatVO = showingSeatVO;
	}

}
