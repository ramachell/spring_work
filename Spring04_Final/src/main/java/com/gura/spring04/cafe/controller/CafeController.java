package com.gura.spring04.cafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gura.spring04.cafe.dto.CafeDto;
import com.gura.spring04.cafe.service.CafeService;

@Controller
public class CafeController {

	@Autowired
	private CafeService service;

	@RequestMapping("/cafe/list")
	public String list(HttpServletRequest request) {
		service.getList(request);
		return "cafe/list";
	};

	@RequestMapping("/cafe/detail")
	public String detail(HttpServletRequest request) {
		service.getDetail(request);
		return "cafe/detail";
	};

	@RequestMapping("/cafe/insertform")
	public String insertForm() {

		return "cafe/insertform";
	}

	@RequestMapping("/cafe/insert")
	public String insert(CafeDto dto, HttpSession session) {
		// wirter는 세션에서 가져옴
		dto.setWriter((String) session.getAttribute("id"));
		service.saveContent(dto);
		return "cafe/insert";
	}

	@RequestMapping("/cafe/updateform")
	public String updateForm(HttpServletRequest request) {
		service.getData(request);
		return "cafe/updateform";
	}

	@RequestMapping("/cafe/update")
	public String update(CafeDto dto) {
		service.updateContent(dto);
		return "cafe/update";
	}

	@RequestMapping("cafe/delete")
	public String delete(int num, HttpServletRequest request) {
		service.deleteContent(num, request);
		return ("cafe/delete");
	}
}
