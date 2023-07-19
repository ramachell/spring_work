package com.example.boot07.users.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.boot07.users.dto.UsersDto;
import com.example.boot07.users.service.UsersService;

@Controller
public class UsersController {
	// 의존객체 주입 받기(DI)
	@Autowired
	private UsersService service;

	// 비밀번호 수정 요청 처리
	@RequestMapping("/users/pwd_update")
	public String pwdUpdate(UsersDto dto, Model model, HttpSession session) {
		// 서비스에 필요한 객체의 참조값을 전달해서 비밀번호 수정 로직을 처리한다.
		service.updateUserPwd(session, dto, model);
		// view page 로 forward 이동해서 작업 결과를 응답한다.

		return "users/pwd_update";
	}

	// 비밀번호 수정폼 요청 처리
	@RequestMapping("/users/pwd_updateform")
	public String pwdUpdateForm() {

		return "users/pwd_updateform";
	}

	// 개인 정보 보기 요청 처리
	@RequestMapping("/users/info")
	public String info(HttpSession session, Model model) {

		service.getInfo(session, model);

		return "users/info";
	}

	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		// 세션에서 id 라는 키값으로 저장된 값 삭제
		session.removeAttribute("id");
		return "users/logout";
	}

	// 로그인 요청 처리
	@RequestMapping("/users/login")
	public ModelAndView login(ModelAndView mView, UsersDto dto, String url, HttpSession session) {
		/*
		 *  서비스에서 비즈니스 로직을 처리할때 필요로  하는 객체를 컨트롤러에서 직접 전달을 해 주어야 한다.
		 *  주로, HttpServletRequest, HttpServletResponse, HttpSession, ModelAndView
		 *  등등의 객체 이다. 
		 */
		service.loginProcess(dto, session);

		// 로그인 후에 가야할 목적지 정보를 인코딩 하지 않는것과 인코딩 한 것을 모두 ModelAndView 객체에 담고
		String encodedUrl = URLEncoder.encode(url);
		mView.addObject("url", url);
		mView.addObject("encodedUrl", encodedUrl);

		// view page 로 forward 이동해서 응답한다.
		mView.setViewName("users/login");
		return mView;
	}

	// 로그인 폼 요청 처리
	@GetMapping("/users/loginform")
	public String loginForm() {

		return "users/loginform";
	}

	// 회원 가입 요청처리
	@RequestMapping(method = RequestMethod.POST, value = "/users/signup")
	public String signup(Model model, UsersDto dto) {
		// 서비스를 이용해서 DB 에 저장하고
		service.addUser(dto);
		// view page 로 forward 이동해서 응답

		return "users/signup";
	}

	/*
	 *  GET 방식 /users/signup_form 요청을 처리할 메소드 
	 *  - 요청방식이 다르면 실행되지 않는다. 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/users/signup_form")
	public String signupForm() {

		return "users/signup_form";
	}

	// ajax 프로필 사진 업로드 요청처리
	@RequestMapping(value = "/users/profile_upload", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> profileUpload(HttpServletRequest request, MultipartFile image) {

		// 서비스를 이용해서 이미지를 upload 폴더에 저장하고 리턴되는 Map 을 리턴해서 json 문자열 응답하기
		return service.saveProfileImage(request, image);
	}

	@RequestMapping("/users/updateform")
	public String updateform(HttpSession session, Model model) {
		service.getInfo(session, model);
		return "users/updateform";
	}

	// 개인정보 수정 반영 요청 처리
	@RequestMapping(value = "/users/update", method = RequestMethod.POST)
	public ModelAndView update(UsersDto dto, HttpSession session, ModelAndView mView, HttpServletRequest request) {
		// 서비스로 정보수정
		service.updateUser(dto, session);
		// 리다일렉트
		mView.setViewName("redirect:/users/info");
		return mView;
	}

	@RequestMapping("/users/delete")
	public String deleteUser(HttpSession session, Model model) {
		service.deleteUser(session, model);

		return "users/delete";
	}

	// application.properties 파일에 있는 정보 얻어내기
	@Value("${file.location}")
	private String fileLocation;

	@GetMapping(value = "/users/image/{imageName}", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE,
			MediaType.IMAGE_PNG_VALUE })
	@ResponseBody
	public byte[] getImage(@PathVariable("imageName") String imageName) throws IOException {
		// imageName엔 응답해줄 이미지의 이름이 들어있다.

		// 읽을 파일 경로
		// fileLocation = application.properties 에 지정
		//
		String absolutePath = fileLocation + File.separator + imageName;
		// 파일 읽을 InputStream
		InputStream is = new FileInputStream(absolutePath);

		// fileLocation 필드에는 파일이 저장되어 있는 서버의 파일 시스템상에서의 위치가 들어있다.

		return IOUtils.toByteArray(is);
	}
}