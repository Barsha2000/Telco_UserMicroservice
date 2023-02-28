package tech.stl.user.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.stl.user.entity.ActivePlan;
import tech.stl.user.entity.PastPlan;
import tech.stl.user.entity.User;
import tech.stl.user.service.UserService;
@CrossOrigin
@RestController
public class UserController {
	@Autowired
    private UserService userService;
	
  
	@GetMapping("/Profile/{userId}")
    public ResponseEntity<User> viewProfile(@PathVariable("userId") int userId) {
		User user = userService.getProfile(userId);
		return ResponseEntity.of(Optional.of(user));
		
	}

	@PostMapping("/Profile")
	public ResponseEntity<User> addUser( @RequestBody User user) {
		User b = null;
		try {
			b = this.userService.addUser(user);
			System.out.println(user);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@GetMapping("/ActivePlan")
	public ResponseEntity<List<ActivePlan>> getActivePlan() {
		List<ActivePlan> list = userService.getActivePlans();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@GetMapping("/ActivePlan/{userId}")
    public ResponseEntity<List<ActivePlan>> viewActive(@PathVariable("userId") int userId) {
		List<ActivePlan> active = userService.getActive(userId);
		return ResponseEntity.of(Optional.of(active));
		
	}
	
	@PostMapping("/ActivePlan")
	public ResponseEntity<ActivePlan> addActivePlan( @RequestBody ActivePlan activePlan) {
		ActivePlan b = null;
		try {
			b = this.userService.addActivePlan(activePlan);
			System.out.println(activePlan);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@GetMapping("/PastPlan")
	public ResponseEntity<List<PastPlan>> getPastPlan() {
		List<PastPlan> list = userService.getPastPlans();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@PostMapping("/PastPlan")
	public ResponseEntity<PastPlan> addPastPlan( @RequestBody PastPlan pastPlan) {
		PastPlan b = null;
		try {
			b = this.userService.addPastPlan(pastPlan);
			System.out.println(pastPlan);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@PostMapping("/Profile/{userId}")
	public ResponseEntity<User> updateDoctor(@Valid @RequestBody User user,
			@PathVariable("userId") int userId) {
		try {
			this.userService.updateProfile(user, userId);
			return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//get plan details by user id(rest template)
	
	
	
	

}
