package com.addis.usersmicorservice.models;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="mydb")
public class UserEntity implements Serializable {
	
	// contains data to be persisted to database
	
	private static final long serialVersionUID = 4316947763467794001L;
	
	@Id
	//@GeneratedValue(generator = "uuid")
	private String userId;
	
	@Column(nullable=false)
	private String firstName;
	
	@Column(nullable=false)
	private String lastName;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	@Column(nullable=false,unique=true,length=120)
	private String password;
	
	@Column(nullable=false,unique=true)
	private String encryptedPassword;
	
	@Column(unique=true)
	private String uniqeUserId;
	
	@DateTimeFormat
	private Date date;
	
	public Date getDate() {
		return date= new Date();
	}

	public void setDate(Date date) {	
		this.date = date;
	}

}
