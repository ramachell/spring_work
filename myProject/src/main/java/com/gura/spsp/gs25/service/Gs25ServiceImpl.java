package com.gura.spsp.gs25.service;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gura.spsp.gs25.dao.Gs25Dao;
import com.gura.spsp.gs25.dto.Gs25Dto;

@Service
public class Gs25ServiceImpl implements Gs25Service {

	@Autowired
	private Gs25Dao dao;

	public void getList(HttpServletRequest request) {
		// 한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT = 8;
		// 하단 페이지를 몇개씩 표시할 것인지
		final int PAGE_DISPLAY_COUNT = 5;

		// 보여줄 페이지의 번호를 일단 1이라고 초기값 지정
		int pageNum = 1;

		// 페이지 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum = request.getParameter("pageNum");
		// 만일 페이지 번호가 파라미터로 넘어 온다면
		if (strPageNum != null) {
			// 숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum = Integer.parseInt(strPageNum);
		}

		// 보여줄 페이지의 시작 ROWNUM
		int startRowNum = 1 + (pageNum - 1) * PAGE_ROW_COUNT;
		// 보여줄 페이지의 끝 ROWNUM
		int endRowNum = pageNum * PAGE_ROW_COUNT;

		/*
		   [ 검색 키워드에 관련된 처리 ]
		   -검색 키워드가 파라미터로 넘어올수도 있고 안넘어 올수도 있다.      
		*/
		String keyword = request.getParameter("keyword");
		String condition = request.getParameter("condition");
		// 만일 키워드가 넘어오지 않는다면
		if (keyword == null) {
			// 키워드와 검색 조건에 빈 문자열을 넣어준다.
			// 클라이언트 웹브라우저에 출력할때 "null" 을 출력되지 않게 하기 위해서
			keyword = "";
			condition = "";
		}

		// 특수기호를 인코딩한 키워드를 미리 준비한다.
		String encodedK = URLEncoder.encode(keyword);

		// FileDto 객체에 startRowNum 과 endRowNum 을 담는다.
		Gs25Dto dto = new Gs25Dto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

		// 만일 검색 키워드가 넘어온다면
		if (!keyword.equals("")) {
			// 검색 종류 하나니까 하나만 넣음
			dto.setName(keyword);
		}

		// 파일 목록을 select 해 온다.(검색 키워드가 있는경우 키워드에 부합하는 전체 글)
		List<Gs25Dto> list = dao.getList(dto);

		// 전체 글의 갯수(검색 키워드가 있는경우 키워드에 부합하는 전체 글의 갯수)
		int totalRow = dao.getCount(dto);

		// 하단 시작 페이지 번호
		int startPageNum = 1 + ((pageNum - 1) / PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		// 하단 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;

		// 전체 페이지의 갯수 구하기
		int totalPageCount = (int) Math.ceil(totalRow / (double) PAGE_ROW_COUNT);
		// 끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
		if (endPageNum > totalPageCount) {
			endPageNum = totalPageCount; // 보정해 준다.
		}

		// 응답에 필요한 데이터를 view page 에 전달하기 위해 request scope 에 담는다
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("keyword", keyword);
		request.setAttribute("encodedK", encodedK);
		request.setAttribute("totalRow", totalRow);
		request.setAttribute("condition", condition);
	}
}
