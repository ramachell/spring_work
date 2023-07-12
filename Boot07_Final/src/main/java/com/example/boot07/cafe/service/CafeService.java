package com.example.boot07.cafe.service;

import javax.servlet.http.HttpServletRequest;

import com.example.boot07.cafe.dto.CafeCommentDto;
import com.example.boot07.cafe.dto.CafeDto;

public interface CafeService {

	public void getList(HttpServletRequest request);

	public void getDetail(HttpServletRequest request);

	public void saveContent(CafeDto dto);

	public void updateContent(CafeDto dto);

	public void deleteContent(int num, HttpServletRequest request);

	// 글 수정하기 위해 글 정보 가져오기
	public void getData(HttpServletRequest request);

	public void saveComment(HttpServletRequest request);// 댓글 저장

	public void deleteComment(HttpServletRequest request);// 댓글 삭제

	public void updateComment(CafeCommentDto dto);// 댓글 수정

	public void moreCommentList(HttpServletRequest request);// 댓글 더보기 기능

}
