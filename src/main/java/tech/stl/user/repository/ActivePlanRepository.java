package tech.stl.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.stl.user.entity.ActivePlan;
import tech.stl.user.entity.User;

@Repository
public  interface ActivePlanRepository extends JpaRepository<ActivePlan, Integer>{
	public List<ActivePlan> findById(int userId);

	public List<ActivePlan> findByUserId(int userId);
	
	
	
	

}
