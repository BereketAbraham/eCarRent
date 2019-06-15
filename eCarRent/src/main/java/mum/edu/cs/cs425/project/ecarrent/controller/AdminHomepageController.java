package mum.edu.cs.cs425.project.ecarrent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomepageController {
	
	@GetMapping(value = "/company/admin/home")
	public String adminHomePage() {
		return "admin/home/adminhome";
	}
	
	@GetMapping(value = "/company/page/underconstruction")
	public String underConstruction() {
		return "general/underconstruction";
	}
	
}
