package com.shop.spring_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.spring_study.repository.ItemRepository;
import com.shop.spring_study.vo.ItemVo;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemRepository ir;
	@GetMapping("/list.do")
	public String list(Model model){
//		Iterable<ItemVo> itemList=ir.findAll();
		model.addAttribute("itemList",ir.findAll());
		return "/item/list";
	}
	@GetMapping("/queryList.do")
	public String queryList(Model model) {
		Iterable<Object[]> Entitis_list= (ir.findAllWithCategoryWithMember());
		model.addAttribute("itemList", Entitis_list);
//		for(Object[] entitis : Entitis_list) {
//			Object item=entitis[0];
//			Object member=entitis[1];
//			Object category=entitis[2];
//			System.out.println(item);
//			System.out.println(member);
//			System.out.println(category);
//		}
		return "/item/queryList";
	}
}
