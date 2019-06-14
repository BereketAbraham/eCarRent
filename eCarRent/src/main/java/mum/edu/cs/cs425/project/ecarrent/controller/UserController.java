package mum.edu.cs.cs425.project.ecarrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import mum.edu.cs.cs425.project.ecarrent.services.IUserService;

@Controller
public class UserController {
	
	@Autowired
    private IUserService userService;

}