package mum.edu.cs.cs425.project.ecarrent.services.implementations;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.cs.cs425.project.ecarrent.model.Booking;
import mum.edu.cs.cs425.project.ecarrent.model.Payment;
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
		return bookingRepository.findAll();
	}

	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Booking findById(Long bId) {
		return bookingRepository.findById(bId).orElse(null);
	}

	@Override
	public void delete(Long bId) {
		bookingRepository.deleteById(bId);
	}

//	@Override
//	public String assignReferenceNumber() {
//		 Long currentId = bookingRepository.findAll().stream()
//				 									 .mapToLong(Booking::getBookingId)
//				 									 .max().getAsLong();
//	     return  "BKN" + (currentId + 1) ;
//	}

}
	