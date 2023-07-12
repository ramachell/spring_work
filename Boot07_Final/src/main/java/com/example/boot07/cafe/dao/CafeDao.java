package com.example.boot07.cafe.dao;

import java.util.List;

import com.example.boot07.cafe.dto.CafeDto;

public interface CafeDao {
	// 글 목록
	public List<CafeDto> getList(CafeDto dto);

	// 글 갯수
	public int getCount(CafeDto dto);

	// 글추가
	public void insert(CafeDto dto);

	// 글정보
	public CafeDto getData(int num);

	// 키워드를 활용한 글정보 얻어오기 (키워드에 부합하는 글중에서 이전글,다음글도 같이)
	public CafeDto getData(CafeDto dto);

	// 조회수 +1
	public void addViewCount(int num);

	// 삭제
	public void delete(int num);

	// 수정
	public void update(CafeDto dto);
}
