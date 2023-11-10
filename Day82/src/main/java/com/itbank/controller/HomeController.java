package com.itbank.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.vo.FileVO;
import com.itbank.service.FileService;

@Controller
public class HomeController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired private FileService fs;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/")
	public String home(MultipartFile upload) {
		
		log.trace("타입 : " + upload.getContentType());
		log.trace("이름1 : " + upload.getName());
		log.trace("이름2 : " + upload.getOriginalFilename());
		log.trace("용량 : " + upload.getSize());
		
		return "redirect:/";
	}
	
	@GetMapping("/ex01")
	public void ex01(Model model) throws IOException {
		model.addAttribute("dir", fs.getDir());
	}
	
	@PostMapping("/ex01")
	public String ex01(MultipartFile upload) throws IOException {
		fs.fileUpload(upload);
		return "redirect:/ex01";
	}
	
	@GetMapping("/ex02")
	public void ex02(Model model) throws IOException {
		model.addAttribute("dir", fs.getDir());
	}
	
	@PostMapping("/ex02")
	public String ex02(MultipartFile upload, String name) throws IOException {
		fs.fileUpload(upload, name);
		
		return "redirect:/ex02";
	}
	
	@GetMapping("/ex03")
	public ModelAndView ex03() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", fs.getFiles());
		
		return mav;
	}
	
	@PostMapping("/ex03")
	public String ex03(FileVO input) throws IOException {
		fs.fileUpload(input);
		
		return "redirect:/ex03";
	}
	
	@GetMapping("/delete/{idx}")
	public String ex03delete(FileVO input) throws IOException {
		fs.delFile(input);
		
		return "redirect:/ex03";
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView ex03update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", fs.getFile(idx));
		mav.setViewName("ex03_update");
		
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public String ex03update(FileVO input) throws IOException {
		fs.updateFile(input);
		
		return "redirect:/ex03";
	}
}
