package com.ktds.showing.list.biz;

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

}
