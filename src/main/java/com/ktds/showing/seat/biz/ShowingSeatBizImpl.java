package com.ktds.showing.seat.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.showing.seat.dao.ShowingSeatDao;
import com.ktds.showing.seat.vo.ShowingSeatVO;

@Component
public class ShowingSeatBizImpl implements ShowingSeatBiz {
	
	@Autowired
	private ShowingSeatDao showingSeatDao;
	
	@Override
	public List<ShowingSeatVO> readAllSeat(int showingNum) {
		return this.showingSeatDao.selectAllSeat(showingNum);
	}
}
