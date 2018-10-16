package com.ktds.movie.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.movie.vo.MovieVO;

@Repository
public class MovieDaoImpl extends SqlSessionDaoSupport implements MovieDao {
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public List<MovieVO> selectAllMovies() {
		return getSqlSession().selectList("MovieDao.selectAllMovies");
	}
	
	@Override
	public int selectOneMovieRunningTime(String movieCode) {
		return getSqlSession().selectOne("MovieDao.selectOneMovieRunningTime", movieCode);
	}
	
	@Override
	public MovieVO selectOneMovie(String movieCode) {
		return getSqlSession().selectOne("MovieDao.selectOneMovie", movieCode);
	}
	
	@Override
	public double selectOneMovieGrade(String movieCode) {
		return getSqlSession().selectOne("MovieDao.selectOneMovieGrade", movieCode);
	}

}
