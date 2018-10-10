package com.ktds.showing.list.vo;

import com.ktds.movie.vo.MovieVO;
import com.ktds.showing.vo.ShowingVO;

public class ShowingListVO {

	String showingId;
	String startDate;
	String endDate;
	int showingNum;
	String movieCode;

	MovieVO movieVO;
	ShowingVO showingVO;

	public String getShowingId() {
		return showingId;
	}

	public void setShowingId(String showingId) {
		this.showingId = showingId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getShowingNum() {
		return showingNum;
	}

	public void setShowingNum(int showingNum) {
		this.showingNum = showingNum;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public MovieVO getMovieVO() {
		return movieVO;
	}

	public void setMovieVO(MovieVO movieVO) {
		this.movieVO = movieVO;
	}

	public ShowingVO getShowingVO() {
		return showingVO;
	}

	public void setShowingVO(ShowingVO showingVO) {
		this.showingVO = showingVO;
	}

	public String getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}

}
