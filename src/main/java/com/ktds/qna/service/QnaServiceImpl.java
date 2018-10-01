package com.ktds.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.qna.dao.QnaDao;
import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.PagerFactory;
import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.PageExplorer;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	QnaDao qnaDao;

	@Override
	public boolean createQna(QnaVO qnaVO) {
		return this.qnaDao.insertQna(qnaVO) > 0;
	}

	@Override
	public QnaVO readOneQna(String qnaId) {
		return this.qnaDao.selectOneQna(qnaId);
	}

	@Override
	public PageExplorer readAllQna(QnaSearchVO qnaSearchVO) {
		int totalCount = this.qnaDao.selectAllQnaCount(qnaSearchVO); // 게시물의 개수를 count해서 페이지의 수 계산
		Pager pager = PagerFactory.getPager(Pager.ORACLE, qnaSearchVO.getPageNo() + ""); // Oracle페이지, 현재 볼 페이지 선택 (몇번부터
																							// 몇번까지의 정보 나옴)

		pager.setTotalArticleCount(totalCount);

		PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, qnaSearchVO); // 시작번호와 끝번호가 나옴

		pageExplorer.setList(this.qnaDao.selectAllQna(qnaSearchVO));

		return pageExplorer;
	}

}
