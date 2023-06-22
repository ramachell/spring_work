package com.gura.spring02.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.guest.dto.GuestDto;
import com.gura.spring02.guest.service.GuestService;

@Controller
public class GuestController {
	// 컨트롤러는 비즈니스 로직을 대신 처리해주는 서비스에 의존한다

	@Autowired
	private GuestService service;

	// 회원 추가 요청 처리
	@RequestMapping("/guest/insert")
	public String insert(GuestDto dto) {
		service.addGuest(dto);
		return "guest/insert";
	}

	// 회원 추가 폼 요청 처리
	@RequestMapping("/guest/insertform")
	public String insertform() {
		return "guest/insertform";
	}

	// 회원 목록 보기 요청 처리
	@RequestMapping("/guest/list")
	public ModelAndView list(ModelAndView mView) {
		service.getGuestList(mView);

		mView.setViewName("guest/list");
		return mView;
	}

	// 정보 수정 폼
	@RequestMapping("/guest/updateform")
	public ModelAndView updateform(ModelAndView mView, int num) {
		service.getGuestInfo(mView, num);

		mView.setViewName("guest/updateform");
		return mView;
	}

	// 회원 정보 수정
	@RequestMapping(method = RequestMethod.POST, value = "/guest/update")
	public String update(GuestDto dto) {
		service.updateGuest(dto);
		return "guest/update";
	}

	// 회원 정보 삭제
	@RequestMapping(method = RequestMethod.POST, value = "/guest/delete")
	public String delete(GuestDto dto) {
		service.deleteGuest(dto);
		return "guest/delete";
	}

}
