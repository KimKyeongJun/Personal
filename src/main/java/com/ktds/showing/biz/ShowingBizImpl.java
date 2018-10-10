package com.ktds.showing.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.showing.dao.ShowingDao;

@Component
public class ShowingBizImpl implements ShowingBiz {
	
	@Autowired
	private ShowingDao showingDao;
	
	@Override
	public List<Integer> readAllShowings() {
		return this.showingDao.selectAllShowings();
	}

}
