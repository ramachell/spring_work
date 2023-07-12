package com.example.boot07.gallery.dao;

import java.util.List;

import com.example.boot07.gallery.dto.GalleryDto;

public interface GalleryDao {
	// list
	public List<GalleryDto> getList(GalleryDto dto);

	// row 갯수(페이징용)
	public int getCount();

	// 저장
	public void insert(GalleryDto dto);

	// num의 사진 정보 (caption 이라던지)
	public GalleryDto getData(int num);

	// 삭제
	public void delete(int num);

}
