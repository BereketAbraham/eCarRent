package mum.edu.cs.cs425.project.ecarrent.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mum.edu.cs.cs425.project.ecarrent.model.Payment;
import mum.edu.cs.cs425.project.ecarrent.repository.IPaymentRepository;
import mum.edu.cs.cs425.project.ecarrent.services.IPaymentService;

@Service("paymentService")
public class PaymentService implements IPaymentService{
	
	private IPaymentRepository paymentRepository;
	
	@Autowired
	public PaymentService(IPaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment save(Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment findById(Long pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long pId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getTotalPrice(Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

}

	
