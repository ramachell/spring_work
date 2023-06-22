package com.gura.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(HttpServletRequest req) {
		List<String> noticeList = new ArrayList<String>();
		noticeList.add("날씨가 많이 추워졌네요");
		noticeList.add("어쩌구...");
		noticeList.add("저쩌구...");
		req.setAttribute("noticeList", noticeList);
		return "home";
	}

	@RequestMapping("/fortune")
	public String fortune(HttpServletRequest request) {
		String fortuneToday = "오늘은 그만 ";
		request.setAttribute("fortuneToday", fortuneToday);

		return "test/fortune";
	}

}
