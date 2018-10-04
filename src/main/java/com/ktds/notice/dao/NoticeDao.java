package com.ktds.notice.dao;

import java.util.List;

import com.ktds.notice.vo.NoticeSearchVO;
import com.ktds.notice.vo.NoticeVO;

public interface NoticeDao {
	
	public int insertOnaNotice(NoticeVO noticeVO);
	
	public List<NoticeVO> selectAllNotice(NoticeSearchVO noticeSearchVO);
	
	public int selectAllNoticeCount(NoticeSearchVO noticeSearchVO);
	
	public NoticeVO selectOneNotice(String noticeId);

}
