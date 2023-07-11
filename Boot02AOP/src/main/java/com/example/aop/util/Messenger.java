package com.example.aop.util;

public class Messenger {

	public void sendGreeting(String msg) {
		System.out.println("오늘의 인사 : " + msg);
	}

	public String getMessage() {
		System.out.println("getMessage() 메소드 수행.");
		return "열심히 공부";
	}
}
