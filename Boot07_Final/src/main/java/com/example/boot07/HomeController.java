package com.example.boot07;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
