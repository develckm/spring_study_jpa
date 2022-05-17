package com.shop.spring_study.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override//controller에 요청이 들어가기 전에 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle :"+request.getServletPath());
		return true;
	}
	@Override//controller가 요청 처리가 끝이나고
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle :"+request.getServletPath());

		
	}
	@Override//view 처리가 끝이나고 
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion :"+request.getServletPath());
		response.getWriter().append("<script>alert('dd')</script>");
	}
}
