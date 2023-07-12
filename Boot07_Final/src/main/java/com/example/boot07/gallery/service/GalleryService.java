package com.example.boot07.gallery.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.example.boot07.gallery.dto.GalleryDto;

public interface GalleryService {
	// 리스트
	public void getList(HttpServletRequest request);

	// 사진 업로드
	public void insert(HttpServletRequest request, GalleryDto dto);

	// 삭제
	public void delete(int num);

	// 자세히보기
	public void select(ModelAndView mView, int num);

}
