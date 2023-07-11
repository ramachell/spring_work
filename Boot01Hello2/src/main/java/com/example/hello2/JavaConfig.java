package com.example.hello2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hello2.util.Remocon;
import com.example.hello2.util.RemoconImpl;
import com.example.hello2.util.TvRemocon;

/*
 * 어떤 객체를 스프링이 생성해서 관리할지 bean설정
 * 
 * xml (...context.xml ) 로 하던걸 class로 하는것 
 */

@Configuration
public class JavaConfig {
	/*
	 * 이 메소드에서 리턴되는 객체를 spring 이 관리하는 bean이 되도록함
	 * 아래의 메소드는 xml 문서에서 <bean id="myCar" class="com.example.demo.Car"/> 와 같다
	 */

	@Bean
	public Car myCar() {
		System.out.println("myCar() 메소드 호출됨");
		Car c1 = new Car();
		return c1;
	}

	// Remocon 인터페이스 type 이 spring 이 관리하는 bean이 되도록 설정

	@Bean
	public Remocon myRemocon() {
		// Remocon r1 = new RemoconImpl();
		return new RemoconImpl();
	}

	@Bean
	public Remocon tvRemocon() {
		return new TvRemocon();
	}
}
