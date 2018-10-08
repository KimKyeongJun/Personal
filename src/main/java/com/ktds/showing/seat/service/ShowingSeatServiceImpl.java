package com.ktds.showing.seat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.showing.seat.biz.ShowingSeatBiz;
import com.ktds.showing.seat.vo.ShowingSeatVO;

@Service
public class ShowingSeatServiceImpl implements ShowingSeatService {
	
	@Autowired
	private ShowingSeatBiz showingSeatBiz;
	
	@Override
	public List<ShowingSeatVO> readAllSeat(int showingNum) {
		return this.showingSeatBiz.readAllSeat(showingNum);
	}
}
