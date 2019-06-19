package mum.edu.cs.cs425.project.ecarrent.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mum.edu.cs.cs425.project.ecarrent.model.Role;
import mum.edu.cs.cs425.project.ecarrent.repository.IRoleRepository;
import mum.edu.cs.cs425.project.ecarrent.services.IRoleService;

@Service("roleService")
public class RoleService implements IRoleService{
	
	private IRoleRepository roleRepository;
	
	@Autowired
	public RoleService(IRoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role findById(Long rId) {
		return roleRepository.findById(rId).orElse(null);
	}

	@Override
	public void delete(Long rId) {
		roleRepository.deleteById(rId);;
		
	}


}