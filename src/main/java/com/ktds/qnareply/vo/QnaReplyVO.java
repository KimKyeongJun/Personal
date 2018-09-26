package com.ktds.qnareply.vo;

import com.ktds.member.vo.MemberVO;
import com.ktds.qna.vo.QnaVO;

public class QnaReplyVO {

	String replyId;
	String content;
	String crtDt;
	QnaVO qnaVO;
	MemberVO memberVO;

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public QnaVO getQnaVO() {
		return qnaVO;
	}

	public void setQnaVO(QnaVO qnaVO) {
		this.qnaVO = qnaVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

}
