package com.gura.spring04.cafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gura.spring04.cafe.dto.CafeCommentDto;
import com.gura.spring04.cafe.dto.CafeDto;
import com.gura.spring04.cafe.service.CafeService;

@Controller
public class CafeController {

	@Autowired
	private CafeService service;

	@RequestMapping("/cafe/comment_insert")
	public String commentInsert(HttpServletRequest request, int ref_group) {
		service.saveComment(request);
		return "redirect:/cafe/detail?num=" + ref_group;
	}

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

	@RequestMapping("cafe/ajax_comment_list")
	public String ajaxComment(HttpServletRequest request) {

		// 테스트위해 3초 시간두려고함
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		service.moreCommentList(request);
		return "cafe/ajax_comment_list";
	}

	@RequestMapping("cafe/comment_update")
	public String update(CafeCommentDto dto) {
		service.updateComment(dto);
		return "cafe/cafe_update";
	}
}
