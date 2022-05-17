package com.shop.spring_study.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.shop.spring_study.vo.MemberVo;

@Component
public class AdminInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//로그인이 되고 Grade<2(0,1)인 사람만 들어올 수 있도록 제한 
		HttpSession session=request.getSession();
		Object  memVo_obj=session.getAttribute("memVo");
		System.out.println("AdminInterceptor.preHandler");
		
		if(memVo_obj!=null && ((MemberVo)memVo_obj).getGrade()<2 ) {
			return true;			
		}else {
			session.setAttribute("msg", "해당 페이지 접근 권한이 없습니다.");
			response.sendRedirect("/");
			return false;
		}
	}
}
