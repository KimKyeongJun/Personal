package com.ktds.showing.list.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
		System.out.println("Service 출력 : " + startDate);
		showingListVO.setStartDate(startDate);
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(startDate);
			System.out.println("Service date 형변환 출력 : " + date);
			Calendar cal = Calendar.getInstance();
			/*cal.get(Calendar.HOUR_OF_DAY);
			cal.set(Calendar.AM_PM, Calendar.AM);*/
		    cal.setTime(date);
		    cal.add(Calendar.MINUTE, movieRunningTime);
		    System.out.println("Service cal 출력 : " + cal.getTime());
			String finishDate = new SimpleDateFormat("yyyy-MM-dd kk:mm").format(cal.getTime());
			System.out.println("Service 끝나는 시간 출력 : " + finishDate);
			showingListVO.setEndDate(finishDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		return this.showingListBiz.registOneShowingList(showingListVO);
	}
	
	@Override
	public List<ShowingListVO> readAllShowingList(String movieCode) {
		return this.showingListBiz.readAllShowingList(movieCode);
	}
	
	@Override
	public ShowingListVO readOneShowingList(String showingId) {
		return this.showingListBiz.readOneShowingList(showingId);
	}

}
