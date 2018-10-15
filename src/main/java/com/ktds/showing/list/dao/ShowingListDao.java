package com.ktds.showing.list.dao;

import java.util.List;
import java.util.Map;

import com.ktds.showing.list.vo.ShowingListVO;

public interface ShowingListDao {
	
	public int insertOneShowingList(ShowingListVO showingListVO);
	
	public String selectEndTimeOfDay(Map<String, String> param);
	
	public int selectStartDateTimeMovie(ShowingListVO showingListVO);
	
	public List<ShowingListVO> selectAllShowingList();
	
	public ShowingListVO selectOneShowingList(String showingId);

}
