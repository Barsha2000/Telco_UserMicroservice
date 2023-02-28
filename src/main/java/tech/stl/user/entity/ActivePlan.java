package tech.stl.user.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActivePlan {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int activeId;
	 int planId;
	 int userId;
	 Date createdDate;
	Date expiryDate;
	public int getActiveId() {
		return activeId;
	}
	public void setActiveId(int activeId) {
		this.activeId = activeId;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public ActivePlan(int activeId, int planId, int userId, Date createdDate, Date expiryDate) {
		super();
		this.activeId = activeId;
		this.planId = planId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.expiryDate = expiryDate;
	}
	public ActivePlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ActivePlan [activeId=" + activeId + ", planId=" + planId + ", userId=" + userId + ", createdDate="
				+ createdDate + ", expiryDate=" + expiryDate + "]";
	} 
}