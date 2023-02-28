package tech.stl.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.stl.user.entity.PastPlan;

@Repository
public  interface PastPlanRepository extends JpaRepository<PastPlan, Integer>{

}
	