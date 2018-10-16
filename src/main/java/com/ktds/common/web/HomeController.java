package com.ktds.common.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.movie.service.MovieService;
import com.ktds.movie.vo.MovieVO;

@Controller
public class HomeController {
	
	@Autowired
	private MovieService movieService;

	@GetMapping("/")
	public ModelAndView viewMainPage() {
		ModelAndView view = new ModelAndView("common/main");
		List<MovieVO> movieList = this.movieService.readAllMovie();
		view.addObject("movieList", movieList);
		return view;
	}
}
