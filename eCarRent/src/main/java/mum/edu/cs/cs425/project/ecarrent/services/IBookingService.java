package mum.edu.cs.cs425.project.ecarrent.services;

import java.util.List;
import mum.edu.cs.cs425.project.ecarrent.model.Booking;

public interface IBookingService {
	
	List<Booking>findAll();
	Booking save(Booking booking);
	Booking findById(Long bId);
	void delete(Long bId);
	String count();

}
