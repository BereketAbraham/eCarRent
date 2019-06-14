package mum.edu.cs.cs425.project.ecarrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mum.edu.cs.cs425.project.ecarrent.model.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Long> {

}
