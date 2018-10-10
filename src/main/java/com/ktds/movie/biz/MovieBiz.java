package com.ktds.movie.biz;

import java.util.List;

import com.ktds.movie.vo.MovieVO;

public interface MovieBiz {
	
	public List<MovieVO> readAllMovies();
	
	public int readOneMovieRunningTime(String movieCode);

}
