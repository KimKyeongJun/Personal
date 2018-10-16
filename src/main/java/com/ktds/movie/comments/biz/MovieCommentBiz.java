package com.ktds.movie.comments.biz;

import java.util.List;

import com.ktds.movie.comments.vo.MovieCommentVO;

public interface MovieCommentBiz {
	
	public boolean registMovieComment(MovieCommentVO movieCommentVO);
	
	public List<MovieCommentVO> readAllMovieCommentOfMovieCode(String movieCode);

}
