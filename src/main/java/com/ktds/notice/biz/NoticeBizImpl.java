package com.ktds.notice.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.notice.dao.NoticeDao;
import com.ktds.notice.vo.NoticeVO;

@Component
public class NoticeBizImpl implements NoticeBiz {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public boolean createOneNotice(NoticeVO noticeVO) {
		return this.noticeDao.insertOnaNotice(noticeVO) > 0;
	}
	
	@Override
	public List<NoticeVO> findselectAllNotice() {
		return this.noticeDao.selectAllNotice();
	}

}
