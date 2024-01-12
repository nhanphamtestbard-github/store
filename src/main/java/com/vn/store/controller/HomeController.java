package com.vn.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController {

	@GetMapping
	public ModelAndView showIndexPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("page", "index");
		modelAndView.setViewName("/index");
		return modelAndView;
	}

	@GetMapping("/list")
	public ModelAndView showWalletPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("page", "list");
		modelAndView.setViewName("/list");
		return modelAndView;
	}
	
	@GetMapping("/temp")
	public String showTempPage() {
		return "/temp";
	}
	
	@GetMapping("/profile")
	public ModelAndView showProfilePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("page", "profile");
		modelAndView.setViewName("/profile");
		return modelAndView;
	}
}
