package com.ktds.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.movie.biz.MovieBiz;
import com.ktds.movie.comments.biz.MovieCommentBiz;
import com.ktds.movie.comments.vo.MovieCommentVO;
import com.ktds.movie.vo.MovieVO;
import com.ktds.showing.biz.ShowingBiz;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieBiz movieBiz;
	
	@Autowired
	private MovieCommentBiz movieCommentBiz;
	
	@Autowired
	private ShowingBiz showingBiz;
	
	@Override
	public Map<String, Object> readAllMovies() {
		Map<String, Object> model = new HashMap<>();
		model.put("movieList", this.movieBiz.readAllMovies());
		model.put("showingList", this.showingBiz.readAllShowings());
		return model;
	}
	@Override
	public List<MovieVO> readAllMovie() {
		return this.movieBiz.readAllMovies();
	}
	
	@Override
	public MovieVO readOneMovie(String movieCode) {
		double grade = this.movieBiz.readOneMovieGrade(movieCode);
		MovieVO movieVO = this.movieBiz.readOneMovie(movieCode);
		movieVO.setGrade(Math.round(grade*100)/100.0);
		List<MovieCommentVO> movieCommentList = this.movieCommentBiz.readAllMovieCommentOfMovieCode(movieCode);
		movieVO.setMovieCommentList(movieCommentList);
		return movieVO;
	}
	
}
