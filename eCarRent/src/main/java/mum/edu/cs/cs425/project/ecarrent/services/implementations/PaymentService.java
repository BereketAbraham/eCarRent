package mum.edu.cs.cs425.project.ecarrent.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mum.edu.cs.cs425.project.ecarrent.model.Payment;
import mum.edu.cs.cs425.project.ecarrent.repository.IPaymentRepository;
import mum.edu.cs.cs425.project.ecarrent.services.IPaymentService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@Service("paymentService")
public class PaymentService implements IPaymentService{
	
	private IPaymentRepository paymentRepository;
	
	@Autowired
	public PaymentService(IPaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment findById(Long pId) {
		return paymentRepository.findById(pId).orElse(null);
	}

	@Override
	public void delete(Long pId) {
		paymentRepository.deleteById(pId);
		
	}

	@Override
	public Double getTotalPrice(Payment payment) {
		// TODO Auto-generated method stub
	
		return null;
	}

	@Override
	public String count() {
		// TODO Auto-generated method stub
		return null;
	}
}

	
