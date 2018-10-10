package com.ktds.movie.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.movie.dao.MovieDao;
import com.ktds.movie.vo.MovieVO;

@Component
public class MovieBizimpl implements MovieBiz {
	
	@Autowired
	private MovieDao movieDao;
	
	@Override
	public List<MovieVO> readAllMovies() {
		return this.movieDao.selectAllMovies();
	}
	
	@Override
	public int readOneMovieRunningTime(String movieCode) {
		return this.movieDao.selectOneMovieRunningTime(movieCode);
	}

}
