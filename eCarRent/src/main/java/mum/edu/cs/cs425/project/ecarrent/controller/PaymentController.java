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


import mum.edu.cs.cs425.project.ecarrent.model.Payment;
import mum.edu.cs.cs425.project.ecarrent.services.IPaymentService;

@Controller
public class PaymentController {
	
	@Autowired
    private IPaymentService paymentService;
	
	@GetMapping(value = "/company/user/payments")
    public ModelAndView managePayments() {
        ModelAndView modelAndView = new ModelAndView();
        List<Payment> payments = paymentService.findAll();
        modelAndView.addObject("payments", payments);
        modelAndView.setViewName("user/payments/payments");
        return modelAndView;
    }
	
	@GetMapping(value = "/company/user/payments/add")
    public String newPaymentForm(Model model) {
		Payment newPayment = new Payment();
        model.addAttribute("payment", newPayment);
        return "user/payments/newpaymentform";
    }
	@PostMapping(value = "/company/user/payments/add/save")
    public String addNewPayment(@Valid @ModelAttribute("payment") Payment payment,
        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "user/payments/newpaymentform";
        }
        payment = paymentService.save(payment);
        return "redirect:/company/user/payments";
    }
	@GetMapping(value = "/company/user/payments/edit/{paymentId}")
    public String editPaymentForm(@PathVariable("paymentId") Long paymentId, Model model) {
		Payment payment = paymentService.findById(paymentId);
        if (payment != null) {
            model.addAttribute("payment", payment);
            return "user/payments/editpaymentform";
        }
        return "user/payments/payments";
    }
	@GetMapping(value="/company/user/payment/delete/{paymentId}")
	public String deletePayment(@PathVariable("paymentId") Long id, Model model){		
		paymentService.delete(id);
		return "redirect:/company/user/payments";
	}
	

}