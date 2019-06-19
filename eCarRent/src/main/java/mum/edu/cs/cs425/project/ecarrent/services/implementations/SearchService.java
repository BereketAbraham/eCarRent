package mum.edu.cs.cs425.project.ecarrent.services.implementations;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import mum.edu.cs.cs425.project.ecarrent.model.Booking;
import mum.edu.cs.cs425.project.ecarrent.model.Category;
import mum.edu.cs.cs425.project.ecarrent.model.Vehicle;
import mum.edu.cs.cs425.project.ecarrent.repository.IBookingRepository;
import mum.edu.cs.cs425.project.ecarrent.repository.ICategoryRepository;
import mum.edu.cs.cs425.project.ecarrent.repository.IVehicleRepository;
import mum.edu.cs.cs425.project.ecarrent.services.ISearchService;

@Service("searchService")
public class SearchService implements ISearchService {
	
	private IVehicleRepository vehicleRepository;
	private IBookingRepository bookingRepository;
	
	public SearchService(IVehicleRepository vehicleRepository, IBookingRepository bookingRepository) {
		this.vehicleRepository = vehicleRepository;
		this.bookingRepository = bookingRepository;
	}
	
	@Override
	public List<Vehicle> getAvailableVehicles(LocalDate start, LocalDate end){
		List<Vehicle> bookedVehicles = bookingRepository.findAll().stream()
				.filter(b -> (b.getStartDate().isBefore(start) && b.getEndDate().isAfter(start))
								|| b.getStartDate().isAfter(start) && b.getStartDate().isBefore(end) )			
				.map(Booking::getVehicle)
				.collect(Collectors.toList());		
		return vehicleRepository.findAll().stream()
				  				.filter(v -> !bookedVehicles.contains(v))
				  				.collect(Collectors.toList()); 
	}

	@Override
	public List<Category> findAvailableCategories(LocalDate start, LocalDate end) {
		return getAvailableVehicles(start, end).stream()
											   .map(v -> v.getCategory())
											   .distinct()
											   .collect(Collectors.toList());
	}

}
