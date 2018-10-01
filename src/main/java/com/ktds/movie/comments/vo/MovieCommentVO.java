package com.ktds.movie.comments.vo;

import com.ktds.member.vo.MemberVO;
import com.ktds.movie.vo.MovieVO;

public class MovieCommentVO {

	String commentId;
	String content;
	double grade;
	MovieVO movieVO;
	MemberVO memberVO;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public MovieVO getMovieVO() {
		return movieVO;
	}

	public void setMovieVO(MovieVO movieVO) {
		this.movieVO = movieVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

}
