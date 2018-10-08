package com.ktds.showing.seat.vo;

import com.ktds.showing.vo.ShowingVO;

public class ShowingSeatVO {

	String seatNumber;
	int showingNum;

	ShowingVO showingVO;

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

	public ShowingVO getShowingVO() {
		return showingVO;
	}

	public void setShowingVO(ShowingVO showingVO) {
		this.showingVO = showingVO;
	}

}
