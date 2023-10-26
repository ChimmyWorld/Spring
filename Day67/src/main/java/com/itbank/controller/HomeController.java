package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")			// 4.3 이후부터 사용 가능한 어노테이션
	public String home() {
		return "home";
	}
	
	@GetMapping("/ex01")
	public void ex01() {}
	
	@PostMapping("/ex01")
	public String ex01(HttpServletRequest request) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		String msg = name + "님은 ";
		msg = age >= 19 ? "성인" : "미성년자";
		msg += "입니다";
		
		request.setAttribute("msg", msg);
		
		return "ex01_result";
	}
	
	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(Model model, String name, int age) {
		// 매개변수와 전송된 parameter의 이름이 같으면 자동으로 저장된다
		
		String msg = name + "님은 ";
		msg += age >= 19 ? "성인" : "미성년자";
		msg += "입니다";
		
		model.addAttribute("msg", msg);
		// model은 request의 Attribute를 대체하는 객체
		
		return "ex01_result"; 
	}
}
