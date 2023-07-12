package com.example.boot07.gallery.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.boot07.gallery.dto.GalleryDto;
import com.example.boot07.gallery.service.GalleryService;

@Controller
public class GalleryController {

	@Autowired
	private GalleryService service;

	@RequestMapping("/gallery/list")
	public String getList(HttpServletRequest request) {
		service.getList(request);
		return ("gallery/list");
	}

	@RequestMapping("/gallery/upload_form")
	public String uploadForm() {
		return "gallery/upload_form";
	}

	@RequestMapping("/gallery/upload_form2")
	public String uploadForm2() {
		return "gallery/upload_form2";
	}

	@RequestMapping("/gallery/upload_form3")
	public String uploadForm3() {
		return "gallery/upload_form3";
	}

	@RequestMapping("/gallery/upload_form4")
	public String uploadForm4() {
		return "gallery/upload_form4";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/gallery/ajax_upload")
	@ResponseBody
	public Map<String, Object> ajaxUpload(GalleryDto dto, HttpServletRequest request) {
		service.insert(request, dto);
		Map<String, Object> map = new HashMap<>();
		map.put("isSuccess", true);

		return map;
	}

	@RequestMapping("/gallery/upload")
	public String upload(HttpServletRequest request, GalleryDto dto) {
		service.insert(request, dto);
		return "gallery/upload";
	}

	@RequestMapping("/gallery/delete")
	public String delete(int num) {
		service.delete(num);
		return "gallery/delete";
	}

	@RequestMapping("/gallery/detail")
	public ModelAndView detail(ModelAndView mView, int num) {
		service.select(mView, num);
		mView.setViewName("gallery/detail");
		return mView;
	}
}
