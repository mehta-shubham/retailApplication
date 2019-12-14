package com.retail.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.retail.annotation.ValidateUserType;

@Entity
@Table(name = "STORE_USERS")
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq_generator")
	@SequenceGenerator(name="seq_generator", sequenceName="users_seq")
	private long id;

	@Column(name = "FIRST_NAME", nullable = false)
	@NotBlank(message = "First Name cannot be Empty")
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false)
	@NotBlank(message = "Last Name cannot be Empty")
	private String lastName;
	
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT", nullable = true)
	private Date updatedAt;
	
	@Column(name = "USER_TYPE", nullable = true)
	@ValidateUserType
	private String userType;

	public User(String firstName, String lastName, String userType, Date createdAt, Date updatedAt) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userType = userType;
	}
	
	protected User() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User is: " + this.getFirstName() + " " + this.getLastName();
	}
}
