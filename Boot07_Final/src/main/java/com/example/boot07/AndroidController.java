package com.example.boot07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot07.cafe.dao.CafeDao;
import com.example.boot07.cafe.dto.CafeDto;

@RestController
public class AndroidController {

	@GetMapping("/android/tweet")
	public String tweet(String msg) {
		System.out.println("안드로이드에서 전송된 문자열 : " + msg);
		return "success! " + msg;
	}

	@GetMapping("/android/tweet2")
	public Map<String, Object> tweet2(String msg) {
		Map<String, Object> map = new HashMap<>();
		System.out.println("안드로이드에서 전송된 문자열2 : " + msg);
		map.put("isSuccess", true);
		return map;
	}

	@GetMapping("/android/tweet3")
	public List<String> tweet3(String msg) {
		System.out.println("안드로이드에서 전송된 문자열3 : " + msg);
		List<String> names = new ArrayList<>();
		names.add("김1");
		names.add("김2");
		names.add("김3");
		return names;
	}

	@Autowired
	private CafeDao dao;

	@GetMapping("/android/list")
	public List<CafeDto> list() {
		CafeDto dto = new CafeDto();
		dto.setStartRowNum(1);
		dto.setEndRowNum(10);

		List<CafeDto> list = dao.getList(dto);
		return list;
	}

}
