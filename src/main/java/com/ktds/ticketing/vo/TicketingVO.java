package com.ktds.ticketing.vo;

import java.util.List;

public class TicketingVO {

	private String ticketingId;
	private String seatNumber;
	private List<String> seatNumberList;
	private int showingNum;
	private String reservationId;

	public String getTicketingId() {
		return ticketingId;
	}

	public void setTicketingId(String ticketingId) {
		this.ticketingId = ticketingId;
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

	public int getShowingNum() {
		return showingNum;
	}

	public void setShowingNum(int showingNum) {
		this.showingNum = showingNum;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

}
