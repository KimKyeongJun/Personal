package com.ktds.movie.vo;

import java.util.List;

import com.ktds.movie.comments.vo.MovieCommentVO;

public class MovieVO {

	String movieCode;
	String movieName;
	int runningTime;
	String poster;
	double grade;

	List<MovieCommentVO> movieCommentList;

	public String getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public List<MovieCommentVO> getMovieCommentList() {
		return movieCommentList;
	}

	public void setMovieCommentList(List<MovieCommentVO> movieCommentList) {
		this.movieCommentList = movieCommentList;
	}

}
