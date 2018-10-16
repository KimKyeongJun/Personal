package com.ktds.movie.comments.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.movie.comments.vo.MovieCommentVO;

@Repository
public class MovieCommentDaoImpl extends SqlSessionDaoSupport implements MovieCommentDao {
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertMovieComment(MovieCommentVO movieCommentVO) {
		return getSqlSession().insert("MovieCommentDao.insertMovieComment", movieCommentVO);
	}
	
	@Override
	public List<MovieCommentVO> selectAllMovieCommentOfMovieCode(String movieCode) {
		return getSqlSession().selectList("MovieCommentDao.selectAllMovieCommentOfMovieCode", movieCode);
	}

}
