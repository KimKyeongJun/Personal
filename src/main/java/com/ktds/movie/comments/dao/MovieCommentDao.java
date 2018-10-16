package com.ktds.movie.comments.dao;

import java.util.List;

import com.ktds.movie.comments.vo.MovieCommentVO;

public interface MovieCommentDao {
	
	public int insertMovieComment(MovieCommentVO movieCommentVO);
	
	public List<MovieCommentVO> selectAllMovieCommentOfMovieCode(String movieCode);

}
