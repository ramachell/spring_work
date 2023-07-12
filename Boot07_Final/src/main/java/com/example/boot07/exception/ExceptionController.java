package com.example.boot07.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
 * Spring MVC가 동작중 특정 type 의 예외가 발생하면 해당 예외를 여기서 처리할수있다
 */
@ControllerAdvice
public class ExceptionController {
	// spring framework 동작중 NotDeleteException 타입 예외 발생시 호출되는 메소드
	@ExceptionHandler(NotDeleteException.class)
	public ModelAndView notDelete(NotDeleteException nde) {
		ModelAndView mView = new ModelAndView();
		// exception 라는 키값으로 예외 객체 담고
		mView.addObject("exception", nde);
		// error/info.jsp 로 forward 이동해서 응답
		mView.setViewName("error/info");
		return mView;
	}

}
