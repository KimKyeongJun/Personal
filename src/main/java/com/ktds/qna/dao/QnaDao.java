package com.ktds.qna.dao;

import java.util.List;

import com.ktds.qna.vo.QnaVO;

public interface QnaDao {
	
	public int insertQna(QnaVO qnaVO);
	
	public List<QnaVO> selectAllQna();
	
	public QnaVO selectOneQna(String qnaId);

}
