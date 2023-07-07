package com.gura.spsp.gs25.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spsp.gs25.dao.Gs25Dao;
import com.gura.spsp.gs25.dto.Gs25Dto;
import com.gura.spsp.gs25.service.Gs25Service;

/**
 * Handles requests for the application home page.
 */
@Controller
public class Gs25Controller {

	@Autowired
	private Gs25Dao dao;

	@Autowired
	private Gs25Service service;

	@RequestMapping("/gs25/fetch")
	public String fetch() {
		return "gs25/fetch";
	}

	@RequestMapping("/gs25/savedb")
	public String savedb() {
		return "gs25/savedb";
	}

	@RequestMapping("/gs25/save")
	@ResponseBody
	public Map<String, Object> save(HttpServletRequest request, Gs25Dto dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", "success");
		dao.save(dto);

		return map;
	}

	@RequestMapping("/gs25/list")
	public String getList(HttpServletRequest request) {
		service.getList(request);
		return "gs25/list";
	}

}
