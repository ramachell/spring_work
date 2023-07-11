package com.example.boot03;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 컨트롤러 메소드에서 리턴하는 내용 바로 클라이언트에게 응답하는 컨트롤러
 * 일반문자열 xml json 형식의 문자열 응답할때 주로사용
 * 모든 컨트롤러에 @ResponsBody 가 기본 적용이라고 생각하면됨 
 */

@RestController
public class HelloController2 {

	@RequestMapping("/hello2")
	public String hello2() {
		return "hello2";
	}
}
