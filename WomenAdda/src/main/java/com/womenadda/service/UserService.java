package com.womenadda.service;

import com.womenadda.model.Address;
import com.womenadda.model.UserRegister;

public interface UserService {

	void addUser(UserRegister u);
	UserRegister getUserById(int userId);
	public String insertAddress(Address address);
}
