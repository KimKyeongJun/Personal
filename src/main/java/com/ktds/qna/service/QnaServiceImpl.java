package com.ktds.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.qna.dao.QnaDao;
import com.ktds.qna.vo.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	QnaDao qnaDao;
	
	@Override
	public boolean createQna(QnaVO qnaVO) {
		return this.qnaDao.insertQna(qnaVO) > 0;
	}
	
	@Override
	public List<QnaVO> readAllQna() {
		return this.qnaDao.selectAllQna();
	}
	
	@Override
	public QnaVO readOneQna(String qnaId) {
		return this.qnaDao.selectOneQna(qnaId);
	}

}
