package com.ktds.showing.seat.dao;

import java.util.List;

import com.ktds.showing.seat.vo.ShowingSeatVO;

public interface ShowingSeatDao {
	
	public List<ShowingSeatVO> selectAllSeat(int showingNum);
	
	public int insertRegistSeat(ShowingSeatVO showingSeatVO);

}
