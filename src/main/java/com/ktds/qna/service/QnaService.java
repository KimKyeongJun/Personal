package com.ktds.qna.service;

import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

public interface QnaService {
	
	public boolean createQna(QnaVO qnaVO);
	
	public QnaVO readOneQna(String qnaId);
	
	public PageExplorer readAllQna(QnaSearchVO qnaSearchVO);

}
