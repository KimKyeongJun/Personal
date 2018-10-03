package com.ktds.notice.service;

import java.util.List;

import com.ktds.notice.vo.NoticeVO;

public interface NoticeService {
	
	public boolean createOnaNotice(NoticeVO noticeVO);
	
	public List<NoticeVO> findAllNotice();

}
