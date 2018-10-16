package com.ktds.movie.dao;

import java.util.List;

import com.ktds.movie.vo.MovieVO;

public interface MovieDao {
	
	public List<MovieVO> selectAllMovies();
	
	public int selectOneMovieRunningTime(String movieCode);
	
	public MovieVO selectOneMovie(String movieCode);
	
	public double selectOneMovieGrade(String movieCode);

}
