package mum.edu.cs.cs425.project.ecarrent.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mum.edu.cs.cs425.project.ecarrent.model.User;
import mum.edu.cs.cs425.project.ecarrent.repository.IUserRepository;
import mum.edu.cs.cs425.project.ecarrent.services.IUserService;

@Service("userService")
public class UserService implements IUserService{
	
	private IUserRepository userRepository;
	
	@Autowired
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Long uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long uId) {
		// TODO Auto-generated method stub
		
	}

}
