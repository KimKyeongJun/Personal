package com.ktds.showing.seat.service;

import java.util.List;

import com.ktds.showing.seat.vo.ShowingSeatVO;

public interface ShowingSeatService {
	
	public List<ShowingSeatVO> readAllSeat(int showingNum);

}
