package mum.edu.cs.cs425.project.ecarrent.services;

import java.util.List;
import mum.edu.cs.cs425.project.ecarrent.model.User;

public interface IUserService {
	
	List<User>findAll();
	User save(User user);
	User findById(Long uId);
	void delete(Long uId);

}
