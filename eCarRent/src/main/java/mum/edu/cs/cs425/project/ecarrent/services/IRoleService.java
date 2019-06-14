package mum.edu.cs.cs425.project.ecarrent.services;

import java.util.List;
import mum.edu.cs.cs425.project.ecarrent.model.Role;

public interface IRoleService {
	
	List<Role>findAll();
	Role save(Role role);
	Role findById(Long rId);
	void delete(Long rId);

}