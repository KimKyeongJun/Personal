package com.ktds.movie.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.movie.comments.vo.MovieCommentVO;
import com.ktds.movie.service.MovieService;
import com.ktds.movie.vo.MovieVO;
import com.nhncorp.lucy.security.xss.XssFilter;

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
	
	@GetMapping("/movie/comment/{movieCode}")
	public ModelAndView viewMovieCommentPage(@PathVariable String movieCode) {
		
		ModelAndView  view = new ModelAndView("movie/comment");
		MovieVO movieVO = this.movieService.readOneMovie(movieCode);
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		for ( MovieCommentVO movieCommentVO : movieVO.getMovieCommentList() ) {
			movieCommentVO.setContent(filter.doFilter(movieCommentVO.getContent()));
		}
		view.addObject("movieVO", movieVO);
		
		return view;
	}
	
}
