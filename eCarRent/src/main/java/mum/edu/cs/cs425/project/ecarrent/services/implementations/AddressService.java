package mum.edu.cs.cs425.project.ecarrent.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.cs.cs425.project.ecarrent.model.Address;
import mum.edu.cs.cs425.project.ecarrent.model.Vehicle;
import mum.edu.cs.cs425.project.ecarrent.repository.IAddressRepository;
import mum.edu.cs.cs425.project.ecarrent.services.IAddressService;

@Service("addressService")
public class AddressService implements IAddressService {
	
	@Autowired
	private IAddressRepository addressRepository;

	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}
	
	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address findById(Long aId) {
		return addressRepository.findById(aId).orElse(null);
	}

	@Override
	public void delete(Long aId) {
		addressRepository.deleteById(aId);
	}
	
}
