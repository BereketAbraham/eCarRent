package mum.edu.cs.cs425.project.ecarrent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {
	
	@GetMapping(value = {"/","/home","/company/home"})
	public String adminHomePage() {
		return "admin/home/adminhome";
	}
	
}
