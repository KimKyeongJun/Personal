package com.ktds.qnareply.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.qnareply.vo.QnaReplyVO;

@Repository
public class QnaReplyDaoImpl extends SqlSessionDaoSupport implements QnaReplyDao {
	
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertOneQnaReply(QnaReplyVO qnaReplyVO) {
		return getSqlSession().insert("QnaReplyDao.insertOneQnaReply", qnaReplyVO);
	}
	

}
