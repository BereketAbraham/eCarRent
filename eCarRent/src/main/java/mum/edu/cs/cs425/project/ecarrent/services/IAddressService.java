package mum.edu.cs.cs425.project.ecarrent.services;

import java.util.List;

import mum.edu.cs.cs425.project.ecarrent.model.Address;
import mum.edu.cs.cs425.project.ecarrent.model.Vehicle;

public interface IAddressService {
	
	List<Address>findAll();
	Address save(Address address);
	Address findById(Long aId);
	void delete(Long aId);

}
