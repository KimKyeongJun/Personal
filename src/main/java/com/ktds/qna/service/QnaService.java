package com.ktds.qna.service;

import java.util.List;

import com.ktds.qna.vo.QnaVO;

public interface QnaService {
	
	public boolean createQna(QnaVO qnaVO);
	
	public List<QnaVO> readAllQna();
	
	public QnaVO readOneQna(String qnaId);

}
