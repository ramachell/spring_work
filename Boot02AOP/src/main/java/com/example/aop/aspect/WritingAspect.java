package com.example.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 *    -Aspectj Expression
 * 
 *    1. execution(* *(..)) => 접근 가능한 모든 메소드가 
 *       point cut
 *    2. execution(* test.service.*.*(..)) 
 *       => test.service 패키지의 모든 메소드 point cut
 *    3. execution(void insert*(..))
 *       =>리턴 type 은 void 이고 메소드명이 
 *       insert 로 시작하는 모든 메소드가 point cut
 *    4. execution(* delete*(*))
 *       => 메소드 명이 delete 로 시작하고 인자로 1개 전달받는 
 *      메소드가 point cut (aop 가 적용되는 위치)
 *    5. execution(* delete*(*,*))
 *       => 메소드 명이 delete 로 시작하고 인자로 2개 전달받는 
 *      메소드가 point cut (aop 가 적용되는 위치)
 *  6. execution(String update*(Integer,*))
 *      => 메소드 명이 update 로 시작하고 리턴 type 은 String
 *      메소드의 첫번째 인자는 Integer type, 두번째 인자는 아무 type 다되는 
 *      메소드가 point cut (aop 가 적용되는 위치)
 */

@Aspect
@Component
public class WritingAspect {

	/*
	 * spring이 관리하는 bean 의 메소드가 수행되기 이전(before)에 적용되는 aspect
	 * 메소드의 pattern 
	 * 
	 * void write*()
	 * 리턴type - void
	 * 메소드명 - write 로 시작하는 메소드
	 * 메소드의 매개변수 - 없음
	 * 
	 * aspect가 적용되는 위치 = "point cut"
	 */

	@Before("execution(void write*())")
	public void prepare() {
		System.out.println("파란색 pen 준비");
	}

	@After(value = "execution(void write*())")
	public void end() {
		System.out.println("pen 닫고 마무리");
	}

}
