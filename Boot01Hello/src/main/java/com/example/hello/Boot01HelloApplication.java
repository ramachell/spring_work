package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Boot01HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot01HelloApplication.class, args);
		// resources 의 config.xml 로딩후 bean 생성해서 관리(legacy 방식)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

		// 스프링이 관리하는 객체중 Car type 을 얻어와서 사용하기
		Car car1 = ctx.getBean(Car.class);
		car1.drive();
	}

}
