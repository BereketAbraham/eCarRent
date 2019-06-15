package mum.edu.cs.cs425.project.ecarrent.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mum.edu.cs.cs425.project.ecarrent.model.Vehicle;
import mum.edu.cs.cs425.project.ecarrent.repository.IVehicleRepository;
import mum.edu.cs.cs425.project.ecarrent.services.IVehicleService;

@Service("vehicleService")
public class VehicleService implements IVehicleService{
	
	private IVehicleRepository vehicleRepository;
	
	@Autowired
	public VehicleService(IVehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle findById(Long vId) {
		return vehicleRepository.findById(vId).orElse(null);
	}

	@Override
	public void delete(Long vId) {
		vehicleRepository.deleteById(vId);
	}

	@Override
	public String assignVehicleNumber() {
		Long currentId = vehicleRepository.findAll().stream().mapToLong(Vehicle::getVehicleId).max().getAsLong();
		return  "VHL" + (currentId + 1) ;
	}

}
