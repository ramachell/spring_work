package com.gura.hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {

		return "home";
	}

	@RequestMapping("/fortune")
	public String fortune(HttpServletRequest request) {
		String fortuneToday = "오늘은 그안 ";
		request.setAttribute("noticeList", fortuneToday);

		return "test/fortune";
	}

}
