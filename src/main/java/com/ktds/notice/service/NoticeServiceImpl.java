package com.ktds.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.notice.biz.NoticeBiz;
import com.ktds.notice.vo.NoticeSearchVO;
import com.ktds.notice.vo.NoticeVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

@Service
public class NoticeServiceImpl implements NoticeService {	
	
	@Autowired
	private NoticeBiz noticeBiz;
	
	@Override
	public boolean createOnaNotice(NoticeVO noticeVO) {
		return this.noticeBiz.createOneNotice(noticeVO);
	}
	
	@Override
	public PageExplorer findAllNotice(NoticeSearchVO noticeSearchVO) {
		return this.noticeBiz.findselectAllNotice(noticeSearchVO);
	}
	
	@Override
	public NoticeVO findOneNotice(String noticeId) {
		return this.noticeBiz.findOneNotice(noticeId);
	}
}
