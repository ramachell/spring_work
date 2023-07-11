package com.example.aop.util;

import org.springframework.stereotype.Component;

@Component
public class WritingUtil {
	public WritingUtil() {
		System.out.println("WritingUtil 생성자");
	}

	public void writeLetter() {
//		System.out.println("파란색 pen 준비");
		System.out.println("편지씀");
//		System.out.println("pen 닫고 마무리");
	}

	public void writeReport() {
//		System.out.println("파란색 pen 준비");
		System.out.println("보고서씀");
//		System.out.println("pen 닫고 마무리");
	}

	public void writeDiray() {
//		System.out.println("파란색 pen 준비");
		System.out.println("일기씀");
//		System.out.println("pen 닫고 마무리");
	}

}
