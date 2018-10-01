package com.ktds.showing.list.vo;

import com.ktds.movie.vo.MovieVO;
import com.ktds.showing.vo.ShowingVO;

public class ShowingListVO {

	String showingId;
	String showingDate;

	MovieVO movieVO;
	ShowingVO showingVO;

	public String getShowingId() {
		return showingId;
	}

	public void setShowingId(String showingId) {
		this.showingId = showingId;
	}

	public String getShowingDate() {
		return showingDate;
	}

	public void setShowingDate(String showingDate) {
		this.showingDate = showingDate;
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

}
