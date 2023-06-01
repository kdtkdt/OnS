package com.ons.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ons.study.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	UserDAO userDao;
	
	public int isMember(String email, String password) {
		return userDao.isMember(email, password);
	}

}
