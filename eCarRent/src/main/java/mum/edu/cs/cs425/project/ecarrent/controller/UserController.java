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


import mum.edu.cs.cs425.project.ecarrent.model.User;
import mum.edu.cs.cs425.project.ecarrent.services.IUserService;

@Controller
public class UserController {
	
	@Autowired
    private IUserService userService;
	
	@GetMapping(value = "/company/user/users")
    public ModelAndView manageUsers() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.findAll();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("user/users/users");
        return modelAndView;
    }
	
	@GetMapping(value = "/company/user/users/add")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/users/newuserform";
    }
	
	@PostMapping(value = "/company/user/users/add/save")
    public String addNewUser(@Valid @ModelAttribute("user") User user,
        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "user/users/newuserform";
        }
        user = userService.save(user);
        return "redirect:/company/user/users";
    }
	
	@GetMapping(value = "/company/user/users/edit/{userId}")
    public String editUserForm(@PathVariable("userId") Long userId, Model model) {
		User user = userService.findById(userId);
        if (user != null) {
            model.addAttribute("user", user);
            return "user/users/edituserform";
        }
        return "user/users/users";
    }
	
	@GetMapping(value="/company/user/users/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Long id, Model model){		
		userService.delete(id);
		return "redirect:/company/user/users";
	}
}