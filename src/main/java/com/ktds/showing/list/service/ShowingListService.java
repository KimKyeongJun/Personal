package com.ktds.showing.list.service;

import java.util.List;

import com.ktds.showing.list.vo.ShowingListVO;

public interface ShowingListService {
	
	public boolean registOneShowingList(ShowingListVO showingListVO);
	
	public List<ShowingListVO> readAllShowingList(String movieCode);

	public ShowingListVO readOneShowingList(String showingId);
}
