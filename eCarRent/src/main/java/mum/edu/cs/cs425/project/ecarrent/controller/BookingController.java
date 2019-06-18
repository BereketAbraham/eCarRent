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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.cs.cs425.project.ecarrent.model.Booking;
import mum.edu.cs.cs425.project.ecarrent.model.Payment;
import mum.edu.cs.cs425.project.ecarrent.model.User;
import mum.edu.cs.cs425.project.ecarrent.model.Vehicle;
import mum.edu.cs.cs425.project.ecarrent.services.IBookingService;
import mum.edu.cs.cs425.project.ecarrent.services.IPaymentService;
import mum.edu.cs.cs425.project.ecarrent.services.IUserService;
import mum.edu.cs.cs425.project.ecarrent.services.IVehicleService;

@Controller
public class BookingController {
	
	@Autowired
    private IBookingService bookingService;
	
	@Autowired
    private IVehicleService vehicleService;
	
	@Autowired
    private IUserService userService;
	
	@Autowired
    private IPaymentService paymentService;
	
	@RequestMapping(value = "/company/admin/bookings", method = RequestMethod.GET)
	public ModelAndView bookingsList() {
		List<Booking> bookings = bookingService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("bookings", bookings);
		modelAndView.setViewName("admin/bookings/bookings");
		return modelAndView;
	}
	
	@RequestMapping(value = "/company/admin/bookings/addnew", method = RequestMethod.GET)
	public String newBookingForm(Model model) {
		Booking newBooking = new Booking();
		//newBooking.setReferenceNumber(bookingService.assignReferenceNumber());
		List<Vehicle> vehicles = vehicleService.findAll();
		List<User> users = userService.findAll();
		List<Payment> payments = paymentService.findAll();
		model.addAttribute("booking", newBooking);
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("users", users);
		model.addAttribute("payments", payments);
		return "admin/bookings/bookingform";
	}
	
	@PostMapping(value = "/company/admin/bookings/addnew/save")
	public String addNewBooking(@Valid @ModelAttribute("booking") Booking booking,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/bookings/bookingform";
		}
		booking = bookingService.save(booking);
		return "redirect:/company/admin/bookings/bookings";
	}
	
	@GetMapping(value = "/company/admin/bookings/edit/{bookingId}")
    public String editBookingForm(@PathVariable("bookingId") Long bookingId, Model model) {
		Booking booking = bookingService.findById(bookingId);
        if (booking != null) {
            model.addAttribute("booking", booking);
            return "admin/bookings/bookingeditform";
        }
        return "admin/bookings/bookings";
    }
	
	@PostMapping(value = "/company/admin/bookings/edit/save")
    public String updateBooking(@Valid @ModelAttribute("booking") Booking booking,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/bookings/bookingeditform";
        }
        booking = bookingService.save(booking);
        return "redirect:/company/admin/bookings";
    }
	
	@GetMapping(value="/company/admin/bookings/delete/{bookingId}")
	public String deleteBooking(@PathVariable("bookingId") Long id){
		bookingService.delete(id);
		return "redirect:/company/admin/bookings/bookings";
	}

}
