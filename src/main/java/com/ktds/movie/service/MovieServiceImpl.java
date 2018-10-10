package com.ktds.movie.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.movie.biz.MovieBiz;
import com.ktds.showing.biz.ShowingBiz;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieBiz movieBiz;
	
	@Autowired
	private ShowingBiz showingBiz;
	
	@Override
	public Map<String, Object> readAllMovies() {
		Map<String, Object> model = new HashMap<>();
		model.put("movieList", this.movieBiz.readAllMovies());
		model.put("showingList", this.showingBiz.readAllShowings());
		return model;
	}
	
}
