package com.gura.spring01;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		// 응답에 필요한 데이터(Model) 이라고 가정하자
		List<String> noticeList = new ArrayList<String>();
		noticeList.add("날씨가 많이 추워졌네요");
		noticeList.add("어쩌구...");
		noticeList.add("저쩌구...");

		// Model 을 request scope 에 특정 key 값으로 담는다.
		request.setAttribute("noticeList", noticeList);
		System.out.println(noticeList + noticeList.get(0));

		// /WEB-INF/views/home.jsp 페이지로 응답을 위임 시키기(forward 이동)
		return "home";

	}

	@RequestMapping("/fortune")
	public String fortune(HttpServletRequest request) {
		String fortuneToday = "오늘은 뭐해 ";
		request.setAttribute("fortuneToday", fortuneToday);

		return "test/fortune";
	}

	@RequestMapping("/fortune2")
	public ModelAndView ModelAndView() {
		String fortuneToday = "오늘은 뭐해2 ";
		ModelAndView mView = new ModelAndView();

		mView.addObject("fortuneToday", fortuneToday);

		mView.setViewName("fortune");

		return mView;
	}

	// ModelAndView 를 매개 변수로 선언하면 알아서 ModelAndView 객체 생성후 참조값 넣어줌
	@RequestMapping("/fortune3")
	public ModelAndView fortune3(ModelAndView mView) {
		// 오늘의 운세 (모델)
		String fortuneToday = "오늘은 그안 ";

		// view page에 전달할 내용
		mView.addObject("fortuneToday", fortuneToday);
		// view page 의 위치도 담기
		mView.setViewName("test/test/test/fortune");
		// 모델과 view page 정보가 모두 담겨있는 ModelAndView 객체 리턴하면 똑같이 동작
		return mView;
	}
}
