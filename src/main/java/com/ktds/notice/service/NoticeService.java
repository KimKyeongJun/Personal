package com.ktds.notice.service;

import com.ktds.notice.vo.NoticeSearchVO;
import com.ktds.notice.vo.NoticeVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

public interface NoticeService {
	
	public boolean createOnaNotice(NoticeVO noticeVO);
	
	public PageExplorer findAllNotice(NoticeSearchVO noticeSearchVO);
	
	public NoticeVO findOneNotice(String noticeId);

}
