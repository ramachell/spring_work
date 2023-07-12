package com.example.boot06;
/*
 * [ Spring MVC 관련 설정]
 * 
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.boot06.interceptor.LoginInterceptor;

/*
 * 	[ Spring MVC 관련 설정 ]
 *  
 *  1. WebMvcConfigurer 인터페이스를 구현한다.
 *  2. 설정에 필요한 메소드만 오버라이딩한다. 
 *     주로 Resource Handler , Interceptor , view page 관련 설정을 여기서 한다.
 *  3. 설정에 관련된 클래스에는 @Configuration 어노테이션을 붙여야한다. 
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
	/*
	 *  servlet-context.xml 에서 설정했던
	 *  
	 *  webapp/resources/ 안에 있는 내용을 서비스 하기위한 
	 *  
	 *  <resources mapping="/resources/**" location="/resources/" />
	 *  
	 *  아래를 설정하면  webapp 에 resources 폴더를 만들어 놓고 그안에 들어 있는 내용에 대한 요청은
	 *  
	 *  spring 프레임워크를 거치지 않고 바로 응답되게 할수 있다. 
	 *  
	 *  - SmartEditor2 나 프로필 이미지를 저장할 upload 폴더를 만들 예정
	 */

	// 여기서 bean 으로 관리 되는 MyInterceptor 객체가 필요하다면...

	@Autowired
	LoginInterceptor inter;

	// @Autowired 어노테이션에서 주입 받은 객체를 이 메소드에서 활용하면 된다.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(inter) //
				.addPathPatterns("/users/*") //
				.excludePathPatterns("/users/loginform") //
				.excludePathPatterns("/users/login");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
