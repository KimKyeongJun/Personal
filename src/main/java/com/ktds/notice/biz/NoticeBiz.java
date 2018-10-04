package com.ktds.notice.biz;

import com.ktds.notice.vo.NoticeSearchVO;
import com.ktds.notice.vo.NoticeVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

public interface NoticeBiz {
	
	public boolean createOneNotice(NoticeVO noticeVO);
	
	public PageExplorer findselectAllNotice(NoticeSearchVO noticeSearchVO);
	
	public NoticeVO findOneNotice(String noticeId);

}
