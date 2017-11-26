package com.flashCard.service;

import com.flashCard.model.User;

public interface LoginService {

    public User validateLogin(User user);

    public String saveLogin(User user);

    public void deleteLogin(int id);

    
}

