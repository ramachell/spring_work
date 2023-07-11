package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.aop.util.MemberDto;

@Aspect
@Component
public class MemberAspect {

	@Around("execution(com.example.aop.util.MemberDto getMember(..))")
	public Object checkMemberDto(ProceedingJoinPoint joinPoint) throws Throwable {

		Object obj = joinPoint.proceed();

		MemberDto dto = (MemberDto) obj;

		dto.setNum(1);
		dto.setName("김구라");
		dto.setAddr("강남");
		return dto;

	}

}
