package mum.edu.cs.cs425.project.ecarrent.services;

import java.util.List;

import mum.edu.cs.cs425.project.ecarrent.model.Address;
import mum.edu.cs.cs425.project.ecarrent.model.Vehicle;

public interface IAddressService {
	
	Address save(Address address);
	Address findById(Long aId);
	void delete(Long aId);

}
