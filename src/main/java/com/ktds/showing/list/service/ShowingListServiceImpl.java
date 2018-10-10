package com.ktds.showing.list.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.movie.biz.MovieBiz;
import com.ktds.showing.list.biz.ShowingListBiz;
import com.ktds.showing.list.vo.ShowingListVO;

@Service
public class ShowingListServiceImpl implements ShowingListService {

	@Autowired
	private ShowingListBiz showingListBiz;
	
	@Autowired
	private MovieBiz movieBiz;

	@Override
	public boolean registOneShowingList(ShowingListVO showingListVO) {
		int movieRunningTime = this.movieBiz.readOneMovieRunningTime(showingListVO.getMovieCode());
		
		String startDate = showingListVO.getStartDate().replace("T", " ");
		showingListVO.setStartDate(startDate);
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.KOREA).parse(startDate);
			Calendar cal = Calendar.getInstance();
		    cal.setTime(date);
		    cal.add(Calendar.MINUTE, movieRunningTime);
			String finishDate = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.KOREA).format(cal.getTime());
			showingListVO.setEndDate(finishDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		return this.showingListBiz.registOneShowingList(showingListVO);
	}

}
