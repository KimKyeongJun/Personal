package com.ktds.movie.comments.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.movie.comments.dao.MovieCommentDao;
import com.ktds.movie.comments.vo.MovieCommentVO;

@Component
public class MovieCommentBizImpl implements MovieCommentBiz{
	
	@Autowired
	private MovieCommentDao movieCommentDao;
	
	@Override
	public boolean registMovieComment(MovieCommentVO movieCommentVO) {
		return this.movieCommentDao.insertMovieComment(movieCommentVO) > 0;
	}
	
	@Override
	public List<MovieCommentVO> readAllMovieCommentOfMovieCode(String movieCode) {
		return this.movieCommentDao.selectAllMovieCommentOfMovieCode(movieCode);
	}

}
