package com.ktds.showing.list.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.showing.list.service.ShowingListService;
import com.ktds.showing.list.vo.ShowingListVO;

@Controller
public class ShowingListController {
	
	@Autowired
	private ShowingListService showingListService;
	
	@PostMapping("/movie/regist")
	@ResponseBody
	public Map<String, Object> doRegistOneShowingListAction(@ModelAttribute ShowingListVO showingListVO) {
		Map<String, Object> result = new HashMap<>();
		System.out.println("ShowingListController 출력 " +showingListVO.getStartDate());
		boolean isRegist = this.showingListService.registOneShowingList(showingListVO);
		result.put("status", isRegist);
		return result;
	}
	
	@GetMapping("/movie/showinglist")
	public ModelAndView viewShowingListPage() {
		List<ShowingListVO> showingList = this.showingListService.readAllShowingList();
		ModelAndView view = new ModelAndView("movie/showinglist");
		view.addObject("showingList", showingList);
		return view;
	}

}
