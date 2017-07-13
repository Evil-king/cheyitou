package com.cheyitou.common.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@RequestMapping("/index")
	public String toIndex(){
		return "home/index";
	}

}
