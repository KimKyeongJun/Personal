package com.ktds.notice.dao;

import java.util.List;

import com.ktds.notice.vo.NoticeVO;

public interface NoticeDao {
	
	public int insertOnaNotice(NoticeVO noticeVO);
	
	public List<NoticeVO> selectAllNotice();

}
