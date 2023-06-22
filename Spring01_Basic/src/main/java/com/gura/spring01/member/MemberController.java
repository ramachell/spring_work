package com.gura.spring01.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gura.spring01.member.dto.MemberDto;

@Controller
public class MemberController {

	@RequestMapping("/member/delete")
	public String delete(int num) {
		System.out.println(num + "번 회원 삭제 완료");
		/*
		 * 리다일렉트 응답 할땐 redirect : 새로 요청할 경로 형식으로 view page 정보를 작성하면됨
		 * 아래는 기본 최상경로 
		 */
		return "redirect:/";
	}

	// "/member/insertform" 요청 처리할 메소드
	@RequestMapping("/member/insertform")
	public String insertform() {

		// 응답할 jsp 페이지의 위치
		return "member/insertform";
	}

	@RequestMapping("/member/insert")
	public String insert(HttpServletRequest request) {
		/*
		 *  [ 요청 파라미터 추출하는 방법 1 ]
		 *  HttpServletRequest 객체를 Controller 메소드로 전달 받아서 직접 추출한다.
		 */

		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		request.setAttribute("formNum", 1);
		System.out.println("insert2 : " + num + "|" + name + "|" + addr);

		return "member/insert";
	}

	@RequestMapping("/member/insert2")
	public String insert2(int num, String name, String addr, HttpServletRequest req) {
		/*
		 *  [ 요청 파라미터 추출하는 방법 2 ]
		 *  
		 *  파라미터명과 동일하게 메소드의 매개변수를 선언해 놓으면 자동으로 추출해서 넣어준다.
		 *  
		 *  <input name="num">  이면  int num or String num
		 *  <input name="email"> 이면  String email  이런 식으로 선언 하면 된다. 
		 */
		req.setAttribute("formNum", 2);
		System.out.println(num + "|" + name + "|" + addr);

		return "member/insert";
	}

	/*
	   *  [ 요청 파라미터 추출하는 방법 3 ]
	   *  
	   *  파라미터명과 동일한 필드명을 가지고 있는 dto 클래스 type 을  메소드의 매개변수로 선언해 놓으면
	   *  자동으로 추출해서 dto 에  추출한 값을 setter 메소드를 이용해서 넣은 다음  해당 dto 객체의 
	   *  참조값이 전달된다.
	   *  
	   *  pulic class MemberDto{
	   *     private int num;  => <input name="num">
	   *     private String name; => <input name="name">
	   *     private String addr; => <input name="addr">
	   *  }
	   *  
	   */
	@RequestMapping("/member/insert3")
	public String insert3(MemberDto dto) {

		System.out.println(dto.getNum() + "|" + dto.getName() + "|" + dto.getAddr());

		return "member/insert";
	}

}
