package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MessengerAspect {

	@Around("execution(void send*(..))")
	public void checkGreeting(ProceedingJoinPoint joinPoint) throws Throwable {
		// 메소드에 전달된 인자들 목록 얻기
		Object[] args = joinPoint.getArgs();
		for (Object tmp : args) {
			// 만일 String type 면
			if (tmp instanceof String) {
				// 원래 type 으로 casting
				String msg = (String) tmp;
				if (msg.contains("또")) {
					System.out.println("사용이 금지된 단어");
					return;
				}
				System.out.println("aspect에서 읽어낸 내용 : " + msg);
			}
		}

		// aspect 가 적용된 메소드가 호출되기 직전에 할 작업은 proceed() 호출 전에 함

		// proceed()호출하여 aspect 가 적용된 메소드가 실행이 된다
		joinPoint.proceed();

		// aspect 적용된 메소드가 호출된 후에 할 작업은 proceed() 후에 한다
		System.out.println("aspect가 적용된 메소드가 리턴 했습니다");

	}
}
