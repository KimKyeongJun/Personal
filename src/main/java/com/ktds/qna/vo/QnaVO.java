package com.ktds.qna.vo;

public class QnaVO {

	int qnaRowNum;
	String qnaId;
	String writer;
	String password;
	String subject;
	String content;
	String isVisible;
	String crtDt;

	public int getQnaRowNum() {
		return qnaRowNum;
	}

	public void setQnaRowNum(int qnaRowNum) {
		this.qnaRowNum = qnaRowNum;
	}

	public String getQnaId() {
		return qnaId;
	}

	public void setQnaId(String qnaId) {
		this.qnaId = qnaId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public String getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}

}
