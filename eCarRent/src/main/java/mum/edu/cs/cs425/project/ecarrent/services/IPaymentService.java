package mum.edu.cs.cs425.project.ecarrent.services;

import java.util.List;
import mum.edu.cs.cs425.project.ecarrent.model.Payment;

public interface IPaymentService {
	
	List<Payment>findAll();
	Payment save(Payment payment);
	Payment findById(Long pId);
	void delete(Long pId);
	String count();
	Double getTotalPrice(Payment payment);

}

	
