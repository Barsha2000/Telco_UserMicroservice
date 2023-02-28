package tech.stl.user.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.stl.user.entity.ActivePlan;
import tech.stl.user.entity.PastPlan;
import tech.stl.user.entity.User;
import tech.stl.user.repository.ActivePlanRepository;
import tech.stl.user.repository.PastPlanRepository;
import tech.stl.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ActivePlanRepository activePlanRepository;
	
	@Autowired
	private PastPlanRepository pastPlanRepository;
	

	//ViewProfile
	public User getProfile(int userId) {
		return this.userRepository.findById(userId);

	}
	

	//Add User
	public User addUser(User user) {
		
		return userRepository.save(user);
	}
	
	//Add Active Plan
    public ActivePlan addActivePlan(ActivePlan activePlan) {
		
		return activePlanRepository.save(activePlan);
	}
    
    //Add Past Plan
    public PastPlan addPastPlan(PastPlan pastPlan) {
		
		return pastPlanRepository.save(pastPlan);
	}

    //view Active plan
	public List<ActivePlan> getActivePlans() {
		return this.activePlanRepository.findAll();
	}
	
	//View Past plan
	public List<PastPlan> getPastPlans() {
		return this.pastPlanRepository.findAll();
	}
	//update profile
	public void updateProfile(User user, int userId) {
		user.setUserId(userId);
		userRepository.saveAndFlush(user);

	}


	public List<ActivePlan> getActive(int userId) {
		
			return this.activePlanRepository.findByUserId(userId);

		}



}
