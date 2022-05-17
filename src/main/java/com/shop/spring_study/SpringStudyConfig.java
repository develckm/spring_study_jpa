package com.shop.spring_study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.shop.spring_study.interceptor.LoginInterceptor;
@Configuration
public class SpringStudyConfig implements WebMvcConfigurer{
	//WebMvcConfigurer spring web mvc의 기본 설정을 모두 할 수 있는 곳 
	@Autowired
	LoginInterceptor loginInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
	}
}
