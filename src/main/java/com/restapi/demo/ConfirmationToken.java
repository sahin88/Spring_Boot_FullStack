package com.restapi.demo;


import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.restapi.user.entity.User;

@Entity
@Table(name="confirmationToken")
public class ConfirmationToken {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="token_id")
	private long token_id;
	@Column(name="confirmation_token")
	private String confirmationToken;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@OneToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(nullable=false,name="id")
	private User userEntity;

	public ConfirmationToken( User userEntity) {
		
		this.userEntity = userEntity;
		createdDate =  new Date();
		confirmationToken = UUID.randomUUID().toString();
	}

	public long getToken_id() {
		return token_id;
	}

	public void setToken_id(long token_id) {
		this.token_id = token_id;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(User userEntity) {
		this.userEntity = userEntity;
	}
	
	
	
	

}
