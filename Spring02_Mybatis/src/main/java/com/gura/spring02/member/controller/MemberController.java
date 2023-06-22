package com.gura.spring02.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.member.dao.MemberDao;
import com.gura.spring02.member.dto.MemberDto;

@Controller
public class MemberController {

	@Autowired
	// auto 하면 dao 엔 new MemberDaoImpl() 이 들어감 (impl~~ 된 인터페이스 객체가 들어감)
	private MemberDao dao;

	// 회원 추가 요청 처리
	@RequestMapping("/member/insert")
	public String insert(MemberDto dto) {
		// MemberDao 객체를 이용해서 DB에 저장
		dao.insert(dto);

		// view page 로 forward 이동
		return "member/insert";
	}

	// 회원 추가 폼 요청 처리
	@RequestMapping("/member/insertform")
	public String insertform() {
		return "member/insertform";
	}

	// 회원 목록 보기 요청 처리
	@RequestMapping("/member/list")
	public String list(HttpServletRequest request) {
		// 회원 목록을 얻어와서
		List<MemberDto> list = dao.getList();
		// request scope 에 담고
		request.setAttribute("list", list);
		// /WEB-INF/views/member/list.jsp 로 forward 이동시킴
		return "member/list";
	}

	// 회원 한명 보기
	@RequestMapping("/member/onemember")
	public String getData(HttpServletRequest request, int num) {
		MemberDto dto = dao.getData(num);
		request.setAttribute("dto", dto);
		return "member/onemember";
	}

	// 정보 수정 폼
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(ModelAndView mView, int num) {
		MemberDto dto = dao.getData(num);
		mView.addObject("dto", dto);
		mView.setViewName("member/updateform");
		return mView;
	}

	// 정보 수정 폼
	// request로 해도 되지만 보통 mView를 많이쓰니까 mView를 쓰는데 음.. 굳이긴한데 어쩄뜬 씀
//	@RequestMapping("/member/updateform")
//	public String updateform(HttpServletRequest request, int num) {
//		MemberDto dto = dao.getData(num);
//		request.setAttribute("dto", dto);
//		return "member/updateform";
//	}

	/*
	 * 	@RequestMapping 에 method 속성의 값을 명시하지 않으면 요청방식을 가리지 않고 경로만 맞으면 모두 처리함
	 * 
	 * 	method 속성의 값을 명시하면 경로가 맞더라도 요청방식 다르면 처리안해줌
	 *  ex) 즉 난 post 전송만 정의해뒀는데  다른사람이 get으로 주소에 막 써서 처리하는거 방지용
	 *  POST 방식일경우 요청방식 정의해주는게 좋음 
	 */

	// 회원 정보 수정 요청 처리
	@RequestMapping(method = RequestMethod.POST, value = "/member/update")
	public String update(MemberDto dto) {
		dao.update(dto);
		return "member/update";
	}

	// 정보 수정
//	@RequestMapping("/member/update")
//	public String update(MemberDto dto) {
//		dao.update(dto);
//		return "member/update";
//	}

	// 회원 정보 삭제
	@RequestMapping("/member/delete")
	public String delete(HttpServletRequest request, int num) {
		request.setAttribute("num", num);
		dao.delete(num);
		return "member/delete";
	}

}
