package com.ktds.notice.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.notice.dao.NoticeDao;
import com.ktds.notice.vo.NoticeSearchVO;
import com.ktds.notice.vo.NoticeVO;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.PagerFactory;
import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.PageExplorer;

@Component
public class NoticeBizImpl implements NoticeBiz {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public boolean createOneNotice(NoticeVO noticeVO) {
		return this.noticeDao.insertOnaNotice(noticeVO) > 0;
	}
	
	@Override
	public PageExplorer findselectAllNotice(NoticeSearchVO noticeSearchVO) {
		int noticeTotalCount = this.noticeDao.selectAllNoticeCount(noticeSearchVO);
		Pager pager = PagerFactory.getPager(Pager.ORACLE, noticeSearchVO.getPageNo() + ""); // Oracle페이지, 현재 볼 페이지 선택 (몇번부터
		// 몇번까지의 정보 나옴)

		pager.setTotalArticleCount(noticeTotalCount);

		PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, noticeSearchVO); // 시작번호와 끝번호가 나옴

		pageExplorer.setList(this.noticeDao.selectAllNotice(noticeSearchVO));
		return pageExplorer;
	}
	
	@Override
	public NoticeVO findOneNotice(String noticeId) {
		return this.noticeDao.selectOneNotice(noticeId);
	}

}
