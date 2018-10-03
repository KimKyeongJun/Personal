package com.ktds.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.notice.vo.NoticeVO;

@Repository
public class NoticeDaoImpl extends SqlSessionDaoSupport implements NoticeDao {

	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertOnaNotice(NoticeVO noticeVO) {
		return getSqlSession().insert("NoticeDao.insertOnaNotice", noticeVO);
	}
	
	@Override
	public List<NoticeVO> selectAllNotice() {
		return getSqlSession().selectList("NoticeDao.selectAllNotice");
	}
	
}
