package com.ktds.ticketing.vo;

import com.ktds.movie.vo.MovieVO;
import com.ktds.reservation.vo.ReservationVO;
import com.ktds.showing.list.vo.ShowingListVO;

public class TicketingVO {

	private String ticketingId;
	private String seatNumber;
	private int showingNum;
	private String reservationId;

	private MovieVO movieVO;
	private ShowingListVO showingListVO;
	private ReservationVO reservationVO;
	
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

	public MovieVO getMovieVO() {
		return movieVO;
	}

	public void setMovieVO(MovieVO movieVO) {
		this.movieVO = movieVO;
	}

	public ShowingListVO getShowingListVO() {
		return showingListVO;
	}

	public void setShowingListVO(ShowingListVO showingListVO) {
		this.showingListVO = showingListVO;
	}

	public ReservationVO getReservationVO() {
		return reservationVO;
	}

	public void setReservationVO(ReservationVO reservationVO) {
		this.reservationVO = reservationVO;
	}

}
