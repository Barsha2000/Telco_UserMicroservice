package tech.stl.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.stl.user.entity.User;

@Repository
public interface  UserRepository  extends JpaRepository<User, Integer> {

//	Object findByEmailId(String email); 
	
	public User findByEmail(String email);
	public User findById(int userId);



}
