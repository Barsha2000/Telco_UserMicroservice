package tech.stl.user.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class PastPlan {
	@Id
	private int pastId;
	private int planId;
	private int userId;
	Date createdDate;
    Date expiryDate;
	public int getPastId() {
		return pastId;
	}
	public void setPastId(int pastId) {
		this.pastId = pastId;
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
	public PastPlan(int pastId, int planId, int userId, Date createdDate, Date expiryDate) {
		super();
		this.pastId = pastId;
		this.planId = planId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.expiryDate = expiryDate;
	}
	public PastPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PastPlan [pastId=" + pastId + ", planId=" + planId + ", userId=" + userId + ", createdDate="
				+ createdDate + ", expiryDate=" + expiryDate + "]";
	}
	
}
