package com.ktds.showing.list.biz;

import java.util.List;

import com.ktds.showing.list.vo.ShowingListVO;

public interface ShowingListBiz {
	
	public boolean registOneShowingList(ShowingListVO showingListVO);
	
	public String readEndTimeOfDay(String startDate, String nextDate);
	
	public boolean findStartDateTimeMovie(ShowingListVO showingListVO);
	
	public List<ShowingListVO> readAllShowingList();

}
