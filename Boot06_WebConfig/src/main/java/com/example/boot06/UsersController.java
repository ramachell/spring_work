package com.example.boot06;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

	@PostMapping("/users/login")
	public String login(HttpSession session, String id) {

		session.setAttribute("id", id);
		return "/home";
	}

	@GetMapping("/users/loginform")
	public String loginform() {
		return "users/loginform";
	}

	@GetMapping("/users/info")
	public String info(Model model) {
		// db에서 읽어온 정보라고 하고 걍 집어넣기
		String addr = "서울 강남 삼원";
		/*
		 * model에 담으면 알아서 HttpServletRequest 에 담김
		 * 즉 아래줄은 request.settAttribute("addr",addr) 과 동일
		 * 그리고 return model 안해도 됨
		 *   
		 */

		model.addAttribute("addr", addr);
		return "users/info";
	}
}
