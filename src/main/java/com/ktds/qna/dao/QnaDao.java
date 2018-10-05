package com.ktds.qna.dao;

import java.util.List;
import java.util.Map;

import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;

public interface QnaDao {
	
	public int insertQna(QnaVO qnaVO);
	
	public QnaVO selectOneQna(String qnaId);

	public List<QnaVO> selectAllQna(QnaSearchVO qnaSearchVO);
	
	public int selectAllQnaCount(QnaSearchVO qnaSearchVO);
	
	public String selectOneQnaCheck(Map<String, String> param);
	
	public String selectGetSaltByQnaId(String qnaId);
}
