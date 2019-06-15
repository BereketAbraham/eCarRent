package mum.edu.cs.cs425.project.ecarrent.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import mum.edu.cs.cs425.project.ecarrent.model.Category;
import mum.edu.cs.cs425.project.ecarrent.services.ICategoryService;

@Controller
public class CategoryController {
	
	@Autowired
    private ICategoryService categoryService;
	
	@GetMapping(value = "/company/admin/categories")
    public ModelAndView manageCategories() {
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);
        modelAndView.setViewName("admin/categories/categories");
        return modelAndView;
    }
	
	@GetMapping(value = "/company/admin/categories/add")
    public String newCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/categories/newcategoryform";
    }
	
	@PostMapping(value = "/company/admin/categories/add/save")
    public String addNewCategory(@Valid @ModelAttribute("category") Category category,
        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/categories/newcategoryform";
        }
        category = categoryService.save(category);
        return "redirect:/company/admin/categories";
    }
	
	@GetMapping(value = "/company/admin/categories/edit/{categoryId}")
    public String editCategoryForm(@PathVariable("categoryId") Long categoryId, Model model) {
		Category category = categoryService.findById(categoryId);
        if (category != null) {
            model.addAttribute("category", category);
            return "admin/categories/editcategoryform";
        }
        return "admin/categories/categories";
    }
	
	@GetMapping(value="/company/admin/categories/delete/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") Long id, Model model){		
		categoryService.delete(id);
		return "redirect:/company/admin/categories";
	}

}
