package mum.edu.cs.cs425.project.ecarrent.services;

import java.util.List;
import mum.edu.cs.cs425.project.ecarrent.model.Vehicle;

public interface IVehicleService {
	
	List<Vehicle>findAll();
	Vehicle save(Vehicle vehicle);
	Vehicle findById(Long vId);
	void delete(Long vId);
	String count();

}
