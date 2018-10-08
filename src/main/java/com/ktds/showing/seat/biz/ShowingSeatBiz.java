package com.ktds.showing.seat.biz;

import java.util.List;

import com.ktds.showing.seat.vo.ShowingSeatVO;

public interface ShowingSeatBiz {
	
	public List<ShowingSeatVO> readAllSeat(int showingNum);

}
