package tech.stl.user.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	private String phoneNumber;
	private String activePlan;
	private String pastPlan;
	private String planExpiry;
	private String email;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getActivePlan() {
		return activePlan;
	}
	public void setActivePlan(String activePlan) {
		this.activePlan = activePlan;
	}
	public String getPastPlan() {
		return pastPlan;
	}
	public void setPastPlan(String pastPlan) {
		this.pastPlan = pastPlan;
	}
	public String getPlanExpiry() {
		return planExpiry;
	}
	public void setPlanExpiry(String planExpiry) {
		this.planExpiry = planExpiry;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
public User(int userId, String userName, String phoneNumber, String activePlan, String pastPlan, String planExpiry,
			String email, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.activePlan = activePlan;
		this.pastPlan = pastPlan;
		this.planExpiry = planExpiry;
		this.email = email;
		this.password = password;
	}

public User() {
	super();
	
	// TODO Auto-generated constructor stub
}
	@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", phoneNumber=" + phoneNumber + ", activePlan="
			+ activePlan + ", pastPlan=" + pastPlan + ", planExpiry=" + planExpiry + ", email=" + email + ", password="
			+ password + "]";
}
	//	public void setPassword(String encodedPassword) {
//		// TODO Auto-generated method stub
//		
//	}
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}	