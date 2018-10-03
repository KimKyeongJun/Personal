package com.ktds.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.notice.biz.NoticeBiz;
import com.ktds.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {	
	
	@Autowired
	private NoticeBiz noticeBiz;
	
	@Override
	public boolean createOnaNotice(NoticeVO noticeVO) {
		return this.noticeBiz.createOneNotice(noticeVO);
	}
	
	@Override
	public List<NoticeVO> findAllNotice() {
		return this.noticeBiz.findselectAllNotice();
	}	
}
