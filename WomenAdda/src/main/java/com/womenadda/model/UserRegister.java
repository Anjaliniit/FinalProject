/**
 * 
 */
package com.womenadda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author admin
 *
 */
@Entity
public class UserRegister implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int userId;

@NotEmpty(message="name can not be empty")
private String name;

@NotEmpty(message="password can not be empty")
private String password;

@NotEmpty(message="gender can not be empty")
private String gender;
@NotEmpty(message="email can not be empty")
private String email;

@Digits(integer=6,fraction=0)
private long zipCode;
@Digits(integer=10,fraction=0)
private long mobile;
/**
 * @return the userId
 */
public int getUserId() {
	return userId;
}
/**
 * @return the zipCode
 */
public long getZipCode() {
	return zipCode;
}
/**
 * @param zipCode the zipCode to set
 */
public void setZipCode(long zipCode) {
	this.zipCode = zipCode;
}
/**
 * @param userId the userId to set
 */
public void setUserId(int userId) {
	this.userId = userId;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
/**
 * @return the gender
 */
public String getGender() {
	return gender;
}
/**
 * @param gender the gender to set
 */
public void setGender(String gender) {
	this.gender = gender;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}

/**
 * @return the mobile
 */
public long getMobile() {
	return mobile;
}
/**
 * @param mobile the mobile to set
 */
public void setMobile(long mobile) {
	this.mobile = mobile;
}

}