package com.ktds.movie.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {
	
	@GetMapping("/movie/movie")
	public String moviePage() {
		return "movie/movie";
	}
}
