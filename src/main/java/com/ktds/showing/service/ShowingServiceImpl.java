package com.ktds.showing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.showing.biz.ShowingBiz;

@Service
public class ShowingServiceImpl implements ShowingService {

	@Autowired
	private ShowingBiz showingBiz;

	@Override
	public List<Integer> readAllShowings() {
		return this.showingBiz.readAllShowings();
	}
}
