package com.ktds.notice.biz;

import java.util.List;

import com.ktds.notice.vo.NoticeVO;

public interface NoticeBiz {
	
	public boolean createOneNotice(NoticeVO noticeVO);
	
	public List<NoticeVO> findselectAllNotice();

}
