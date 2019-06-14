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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle save(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle findById(Long vId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long vId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String count() {
		// TODO Auto-generated method stub
		return null;
	}

}
