package com.womenadda.dao;

import java.util.List;

import com.womenadda.model.Address;
import com.womenadda.model.UserRegister;

public interface UserDAO {

	void addUser(UserRegister u);
	UserRegister getUserById(int userId);
	String insertAddress(Address address);
	
	

}
