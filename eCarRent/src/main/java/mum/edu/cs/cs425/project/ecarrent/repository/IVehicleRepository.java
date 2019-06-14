package mum.edu.cs.cs425.project.ecarrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mum.edu.cs.cs425.project.ecarrent.model.Vehicle;

@Repository("vehicleRepository")
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

}