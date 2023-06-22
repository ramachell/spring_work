package com.gura.spring03.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 *  [ 인터 셉터 만들기]
 *  
 *  1. HandlerInterceptor 인터페이스를 구현
 * 	2. servlet-context.xml 에 bean 설정을 하고 interceptor 목록에 등록하고 맵핑해줌
 */

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

//	// controller 실행 이전에 호출되는 메소드
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		request.setAttribute("msg", "인터셉터1");
//		System.out.println("preHandle()");
//		// true 리턴시 흐름 계속 잇고 false시 끊김
//		return true;
//	}
//
//	// controller 실행이후에 호출되는 메소드
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		request.setAttribute("msg", "인터셉터2");
//		System.out.println("postHandle()");
//	}
//
//	// 응답이후 호출되는 메소드
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		request.setAttribute("msg", "인터셉터3");
//		System.out.println("afterCompletion()");
//	}

}
