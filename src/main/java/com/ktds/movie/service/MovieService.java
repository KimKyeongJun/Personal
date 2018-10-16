package com.ktds.movie.service;

import java.util.List;
import java.util.Map;

import com.ktds.movie.vo.MovieVO;

public interface MovieService {
	
	public Map<String, Object> readAllMovies();
	
	public  List<MovieVO> readAllMovie();
	
	public MovieVO readOneMovie(String movieCode);

}
