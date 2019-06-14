package mum.edu.cs.cs425.project.ecarrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import mum.edu.cs.cs425.project.ecarrent.services.ICategoryService;

@Controller
public class CategoryController {
	
	@Autowired
    private ICategoryService categoryService;

}
