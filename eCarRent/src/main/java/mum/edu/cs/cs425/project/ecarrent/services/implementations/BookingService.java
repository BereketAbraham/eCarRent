package mum.edu.cs.cs425.project.ecarrent.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mum.edu.cs.cs425.project.ecarrent.model.Booking;
import mum.edu.cs.cs425.project.ecarrent.repository.IBookingRepository;
import mum.edu.cs.cs425.project.ecarrent.services.IBookingService;

@Service("bookingService")
public class BookingService implements IBookingService{
	
	private IBookingRepository bookingRepository;
	
	@Autowired
	public BookingService(IBookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	public List<Booking> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking save(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking findById(Long bId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long bId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String assignBookingNumber() {
		// TODO Auto-generated method stub
		return null;
	}

}
	