package com.ktds.movie.comments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.movie.comments.biz.MovieCommentBiz;
import com.ktds.movie.comments.vo.MovieCommentVO;

@Service
public class MovieCommentServiceImpl implements MovieCommentService {
	
	
	@Autowired
	private MovieCommentBiz movieCommentBiz;
	
	@Override
	public boolean registMovieComment(MovieCommentVO movieCommentVO) {
		return this.movieCommentBiz.registMovieComment(movieCommentVO);
	}

}
