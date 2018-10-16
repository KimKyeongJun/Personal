package com.ktds.movie.comments.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktds.common.session.Session;
import com.ktds.member.vo.MemberVO;
import com.ktds.movie.comments.service.MovieCommentService;
import com.ktds.movie.comments.vo.MovieCommentVO;

@Controller
public class MovieCommentController {
	
	@Autowired
	private MovieCommentService movieCommentService;
	
	@PostMapping("/movie/comment")
	@ResponseBody
	public boolean doRegistMovieCommentAction(@ModelAttribute MovieCommentVO movieCommentVO, @SessionAttribute(Session.USER) MemberVO memberVO) {
		movieCommentVO.setId(memberVO.getId());
		return this.movieCommentService.registMovieComment(movieCommentVO);
	}
	
}
