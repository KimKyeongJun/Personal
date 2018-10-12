package com.ktds.reservation.vo;

import java.util.List;

import com.ktds.member.vo.MemberVO;
import com.ktds.showing.list.vo.ShowingListVO;
import com.ktds.showing.seat.vo.ShowingSeatVO;

public class ReservationVO {

	private String reservationId;
	private String reservationDate;
	private String showingId;
	private List<String> seatNumberList;
	private String seatNumber;
	private int showingNum;
	private String name;
	private String phone;
	private String id;

	private MemberVO memberVO;
	private ShowingListVO showingListVO;
	private ShowingSeatVO showingSeatVO;

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

	public String getShowingId() {
		return showingId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setShowingId(String showingId) {
		this.showingId = showingId;
	}

	public int getShowingNum() {
		return showingNum;
	}

	public void setShowingNum(int showingNum) {
		this.showingNum = showingNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public List<String> getSeatNumberList() {
		return seatNumberList;
	}

	public void setSeatNumberList(List<String> seatNumberList) {
		this.seatNumberList = seatNumberList;
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
