package mum.edu.cs.cs425.project.ecarrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import mum.edu.cs.cs425.project.ecarrent.services.IPaymentService;

@Controller
public class PaymentController {
	
	@Autowired
    private IPaymentService paymentService;

}