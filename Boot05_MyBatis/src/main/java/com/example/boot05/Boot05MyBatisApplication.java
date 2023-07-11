package com.example.boot05;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot05MyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot05MyBatisApplication.class, args);

		// 서버 실행후 페이지열기
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("cmd /c start chrome.exe http://localhost:9000/boot05");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
