package mum.edu.cs.cs425.project.ecarrent.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mum.edu.cs.cs425.project.ecarrent.model.Credential;
import mum.edu.cs.cs425.project.ecarrent.repository.ICredentialRepository;
import mum.edu.cs.cs425.project.ecarrent.services.ICredentialService;

@Service("credentialService")
public class CredentialService implements ICredentialService{
	
	private ICredentialRepository credentialRepository;
	
	@Autowired
	public CredentialService(ICredentialRepository credentialRepository) {
		this.credentialRepository = credentialRepository;
	}

	@Override
	public List<Credential> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Credential save(Credential credential) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Credential findById(Long cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long cId) {
		// TODO Auto-generated method stub
		
	}

}
	
