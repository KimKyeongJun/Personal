package com.ktds.movie.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.movie.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;	
	
	@GetMapping("/movie/movie")
	public ModelAndView moviePage() {
		ModelAndView view = new ModelAndView("movie/movie");
		Map<String, Object> model = this.movieService.readAllMovies();
		view.addObject("movieList",model.get("movieList"));
		view.addObject("showingList",model.get("showingList"));
		return view;
	}
	
}
