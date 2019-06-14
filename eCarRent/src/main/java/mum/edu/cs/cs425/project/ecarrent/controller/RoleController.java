package mum.edu.cs.cs425.project.ecarrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import mum.edu.cs.cs425.project.ecarrent.services.IRoleService;

@Controller
public class RoleController {
	
	@Autowired
    private IRoleService roleService;

}