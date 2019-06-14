package mum.edu.cs.cs425.project.ecarrent.services;

import java.util.List;
import mum.edu.cs.cs425.project.ecarrent.model.Credential;

public interface ICredentialService {
	
	List<Credential>findAll();
	Credential save(Credential credential);
	Credential findById(Long cId);
	void delete(Long cId);

}
	
