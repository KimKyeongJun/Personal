package com.ktds.qna.dao;

import java.util.List;

import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;

public interface QnaDao {
	
	public int insertQna(QnaVO qnaVO);
	
	public QnaVO selectOneQna(String qnaId);

	public List<QnaVO> selectAllQna(QnaSearchVO qnaSearchVO);
	
	public int selectAllQnaCount(QnaSearchVO qnaSearchVO);
}
