package com.ktds.qna.biz;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.common.util.SHA256Util;
import com.ktds.qna.dao.QnaDao;
import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.PagerFactory;
import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.PageExplorer;


@Component
public class QnaBizImpl implements QnaBiz {
	
	@Autowired
	QnaDao qnaDao;

	@Override
	public boolean createQna(QnaVO qnaVO) {
		String salt = SHA256Util.generateSalt();
		String password = SHA256Util.getEncrypt(qnaVO.getPassword(), salt);
		qnaVO.setPassword(password);
		qnaVO.setSalt(salt);
		
		return this.qnaDao.insertQna(qnaVO) > 0;
	}
	
	public String getHashedPassword(String salt, String password) {
		return SHA256Util.getEncrypt(password, salt);
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
	
	@Override
	public String readGetSaltByQnaId(String qnaId) {
		return this.qnaDao.selectGetSaltByQnaId(qnaId);
	}
	
	@Override
	public String readOneQnaCheck(String qnaId, String password) {
		Map<String, String> param = new HashMap<>();
		String salt = readGetSaltByQnaId(qnaId);
		String saltPassword = getHashedPassword(salt,password);
		param.put("qnaId", qnaId);
		param.put("password", saltPassword);
		return this.qnaDao.selectOneQnaCheck(param);
	}

}
