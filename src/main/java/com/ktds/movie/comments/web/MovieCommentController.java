package com.ktds.movie.comments.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieCommentController {

	
	@GetMapping("/movie/comment")
	public String viewMovieCommentPage() {
		return "movie/comment";
	}
	
}
