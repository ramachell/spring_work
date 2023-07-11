package com.example.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.aop.util.MemberDto;
import com.example.aop.util.MemberService;
import com.example.aop.util.Messenger;
import com.example.aop.util.WritingUtil;

/*
 * @SpringBootApplication 어노테이션이 붙어있는 main 메소드가 존재하는 (이패키지 포함)
 * 
 * 하위의 모든 패키지에 component scan 이 자동으로 일어난다
 */
@SpringBootApplication
public class Boot02AopApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Boot02AopApplication.class, args);
		WritingUtil ut = ctx.getBean(WritingUtil.class);
		ut.writeLetter();
		ut.writeReport();
		ut.writeDiray();

		System.out.println("----------------------------------");
		Messenger m1 = ctx.getBean(Messenger.class);
		String msg = m1.getMessage();
		System.out.println("Messenger 객체로부터 받은 메시지 : " + msg);
		System.out.println();
		m1.sendGreeting("안녕하세요");
		System.out.println();
		m1.sendGreeting("안녕!");
		System.out.println();
		m1.sendGreeting("또 만났군요");

		MemberService service = ctx.getBean(MemberService.class);
		MemberDto dto = service.getMember(1);
		System.out.println(dto.getNum());
		System.out.println(dto.getName());
		System.out.println(dto.getAddr());
	}

}
