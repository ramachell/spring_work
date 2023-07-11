package com.example.boot04;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		List<String> list = new ArrayList<>();
		list.add("Spring Boot 시작");
		list.add("어쩌쩌저저저 고");
		list.add("저ㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ쩌고");

		request.setAttribute("list", list);

		return "home";
	}

	@GetMapping("/fortune")
	public String fortune(HttpServletRequest request) {
		// ModelAndView 로 해도됨
		String fortune = "오늘은 카톡이 왔어요";
		request.setAttribute("fortune", fortune);
		return "fortune";
	}

	@GetMapping("/fortune2")
	public ModelAndView fortune2(ModelAndView mView) {
		// ModelAndView 로 해도됨
		String fortune = "오늘은 카톡이 왔어요";
		mView.addObject("fortune", fortune);
		mView.setViewName("fortune");
		return mView;
	}

}
