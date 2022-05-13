package com.shop.spring_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.spring_study.repository.CategoryRepository;
import com.shop.spring_study.vo.CategoryVo;

@Controller
@RequestMapping("/cate")
public class CategoryController {
	@Autowired
	CategoryRepository cr;
	@GetMapping("list.do")
	public String list(Model model) {
		Iterable<CategoryVo> cateList=cr.findAll();
		model.addAttribute("cateList",cateList);
		return "/cate/list";
	}
}
