package com.ktds.qna.biz;

import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

public interface QnaBiz {

	public boolean createQna(QnaVO qnaVO);

	public QnaVO readOneQna(String qnaId);

	public PageExplorer readAllQna(QnaSearchVO qnaSearchVO);
	
	public String readGetSaltByQnaId(String qnaId);
	
	public String readOneQnaCheck(String qnaId, String password);

}
