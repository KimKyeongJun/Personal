package com.ktds.reservation.vo;

import com.ktds.member.vo.MemberVO;
import com.ktds.movie.vo.MovieVO;
import com.ktds.showing.list.vo.ShowingListVO;
import com.ktds.showing.seat.vo.ShowingSeatVO;

public class ReservationVO {

	private String reservationId;
	private int originPrice;
	private int payPrice;
	private int useMileage;
	private String showingId;
	private String id;
	private String reservationDate;
	private String phone;
	private String name;

	private MemberVO memberVO;
	private ShowingListVO showingListVO;
	private ShowingSeatVO showingSeatVO;
	private MovieVO movieVO;

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public int getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(int originPrice) {
		this.originPrice = originPrice;
	}

	public int getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}

	public int getUseMileage() {
		return useMileage;
	}

	public void setUseMileage(int useMileage) {
		this.useMileage = useMileage;
	}

	public String getShowingId() {
		return showingId;
	}

	public void setShowingId(String showingId) {
		this.showingId = showingId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public MovieVO getMovieVO() {
		return movieVO;
	}

	public void setMovieVO(MovieVO movieVO) {
		this.movieVO = movieVO;
	}

}
