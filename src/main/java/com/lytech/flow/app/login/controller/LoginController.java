package com.lytech.flow.app.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytech.flow.app.login.vo.LoginVO;
import com.lytech.flow.app.transcation.entity.Transcations;
import com.lytech.flow.app.transcation.service.TranscationService;
import com.lytech.flow.app.transcation.vo.TranscationVO;

@Controller
public class LoginController {

	@Autowired
	private TranscationService getTranscationService;
	
	@GetMapping("/login")
	private String show() {
		
		return "login";
	}
	
	@GetMapping("/logout")
	private String logout() {
		
		return "login";
	}
	
	@PostMapping(value="/auth", consumes = "application/x-www-form-urlencoded")
	private String auth(Model model, LoginVO loginVO) {
		
		if("companyA".equals(loginVO.getUsername())) {
			model.addAttribute("companyName", "会社A");
			model.addAttribute("companyType", "A");
			model.addAttribute("companyTypeName", "依頼会社");
		} else if("companyB".equals(loginVO.getUsername())) {
			model.addAttribute("companyName", "会社B");
			model.addAttribute("companyType", "B");
			model.addAttribute("companyTypeName", "協力会社");
		} else if("companyC".equals(loginVO.getUsername())) {
			model.addAttribute("companyName", "会社C");
			model.addAttribute("companyType", "C");
			model.addAttribute("companyTypeName", "製作会社");
		} else if("companyD".equals(loginVO.getUsername())) {
			model.addAttribute("companyName", "会社D");
			model.addAttribute("companyType", "D");
			model.addAttribute("companyTypeName", "審査機関");
		} else {
			model.addAttribute("companyName", "会社名");
			return "error";
		}
		
		return "index";
	}
	
	@PostMapping("/transcation")
	@ResponseBody
	private void addTranscations() {
		
		getTranscationService.addTranscation();
	}
	
	@PutMapping("/transcation")
	@ResponseBody
	private void updateTranscations(TranscationVO transcationVO) {
		
		getTranscationService.updateTranscation(transcationVO);
	}
	
	@GetMapping("/transcation")
	@ResponseBody
	private List<Transcations> getTranscations() {
		
		return getTranscationService.getTranscations();
	}
}
