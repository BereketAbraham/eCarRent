package mum.edu.cs.cs425.project.ecarrent.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.cs.cs425.project.ecarrent.model.Booking;
import mum.edu.cs.cs425.project.ecarrent.model.Category;
import mum.edu.cs.cs425.project.ecarrent.services.implementations.CategoryService;
import mum.edu.cs.cs425.project.ecarrent.services.implementations.SearchService;
import mum.edu.cs.cs425.project.ecarrent.utility.RequestPeriod;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/company/search")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    public ModelAndView searchVehicles(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate start, @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
		ModelAndView modelAndView = new ModelAndView();
        List<Category> availableCategories = searchService.findAvailableCategories(start, end);
        modelAndView.addObject("availableCategories", availableCategories);
        modelAndView.setViewName("public/search/results");
        return modelAndView;
    }
//	
//	@GetMapping(value = "/company/search")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//    public ModelAndView searchVehicles(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate start, @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
//		ModelAndView modelAndView = new ModelAndView();
//        List<Category> availableCategories = categoryService.findAll();
//        modelAndView.addObject("availableCategories", availableCategories);
//        modelAndView.setViewName("public/search/results");
//        return modelAndView;
//    }

}
