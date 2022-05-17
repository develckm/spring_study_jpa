package com.shop.spring_study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.shop.spring_study.interceptor.AdminInterceptor;
import com.shop.spring_study.interceptor.LoginInterceptor;
@Configuration
public class SpringStudyConfig implements WebMvcConfigurer{
	//WebMvcConfigurer spring web mvc의 기본 설정을 모두 할 수 있는 곳 
	@Autowired
	LoginInterceptor loginInterceptor;//로그인된 유저만 입장 
	@Autowired
	AdminInterceptor adminInterceptor;//관리자 권한 입장 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/")
		.excludePathPatterns("/mem/login")
		.excludePathPatterns("/mem/signup")
		.excludePathPatterns("/public/**")
		.excludePathPatterns("/mem/ajax/**")
		.excludePathPatterns("/item/list/**");
		
		registry.addInterceptor(adminInterceptor)
		.addPathPatterns("/*/admin/**");
		
	}
}







