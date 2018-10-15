package com.ktds.showing.list.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.showing.list.dao.ShowingListDao;
import com.ktds.showing.list.vo.ShowingListVO;

@Component
public class ShowingListBizImpl implements ShowingListBiz {

	@Autowired
	private ShowingListDao showingListDao;

	@Override
	public boolean registOneShowingList(ShowingListVO showingListVO) {
		return this.showingListDao.insertOneShowingList(showingListVO) > 0;
	}
	
	@Override
	public String readEndTimeOfDay(String startDate, String nextDate) {
		Map<String, String> param = new HashMap<>();
		param.put("startDate", startDate);
		param.put("nextDate", nextDate);
		return this.showingListDao.selectEndTimeOfDay(param);
	}
	
	@Override
	public boolean findStartDateTimeMovie(ShowingListVO showingListVO) {
		int resultShowingListVO  = this.showingListDao.selectStartDateTimeMovie(showingListVO);
		System.out.println("Biz 출력 : " + resultShowingListVO);
		return true;
		/*
		if ( resultShowingListVO == null ) {
			return true;
		}
		else {			
			return false;
		}*/
	}
	
	@Override
	public List<ShowingListVO> readAllShowingList() {
		return this.showingListDao.selectAllShowingList();
	}
	
	@Override
	public ShowingListVO readOneShowingList(String showingId) {
		return this.showingListDao.selectOneShowingList(showingId);
	}

}
