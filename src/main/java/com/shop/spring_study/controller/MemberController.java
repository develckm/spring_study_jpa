package com.shop.spring_study.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.shop.spring_study.repository.MemberRepository;
import com.shop.spring_study.vo.MemberVo;

@Controller
@RequestMapping("/mem")
public class MemberController {
//	필요할때 스프링이 생성한 객체(컨테이너)를 주입(의존성 주입)
	@Autowired
	MemberRepository mr;
	@GetMapping("list.do")
	public String list(Model model) {
		Iterable<MemberVo> memList=mr.findAllByOrderByIdAsc();
		model.addAttribute("memList",memList);
//		model.addAttribute("test",10);
		return "mem/list";
	}
//	초창기 모델
//	@GetMapping("list.do")
//	public ModelAndView list(ModelAndView model) {
//		model.addObject("test",10);
//		model.setViewName("mem/list");
//		return model;
//	}
	@GetMapping(value="/login")
	public String login() {
		return "/mem/login";
	}
	@PostMapping("/login")
//	톰캣서버에 필요한 객체가 있다면 매개변수로 작성하면 사용가능
	public String login(String id, String pw, HttpSession session) { // 오버로딩 
		System.out.println(id+"/"+pw);
		MemberVo memVo=mr.findByIdAndPw(id, pw);
		if(memVo!=null) {
			session.setAttribute("memVo", memVo);
			return "redirect:/"; // response.sendRedirect("/")			
		}else {
			return "redirect:/mem/login";
		}
	}
	@GetMapping("/signup")
	public ModelAndView signup(ModelAndView model) { // 맨위 public String login이랑 비교하면됨.
		model.setViewName("/mem/signup");
		return model;
	}
	@PostMapping("/signup")
	public String singup(MemberVo memVo, HttpSession session) {
		boolean insert=false;
		try {
			Optional<MemberVo> memOption=mr.findById(memVo.getId()); // 기본으로 제공되는 함수
			if(memOption.isEmpty()) { // 있는지 검사해서 없을때만 저장
				MemberVo insertMem=mr.save(memVo);
				System.out.println(insertMem);
				if(insertMem!=null) {
					insert=true;
				}else {
					session.setAttribute("msg", "존재하는 아이디입니다.");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("msg", "Email 또는 Phone이 이미 존재합니다.");
		}
		if(insert) {
			return "redirect:/mem/list.do";			
		}else {
			return "redirect:/mem/signup";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/ajax/findId/{id}")
	public @ResponseBody Optional<MemberVo> findId(@PathVariable String id) {
		return mr.findById(id);
	}
	@GetMapping("/ajax/findEmail/{email}")
	public @ResponseBody Optional<MemberVo> findEmail(@PathVariable String email){
		return mr.findByEmail(email);
	}
	@GetMapping("/ajax/findPhone/{phone}")
	public @ResponseBody Optional<MemberVo> findByPhone(@PathVariable String phone){
		return mr.findByPhone(phone);
	}
	
}

