package com.flashCard.dao;

import com.flashCard.model.User;

public interface LoginDao {

	public String saveLogin(User user);
	public User validateLogin(User login);
}
