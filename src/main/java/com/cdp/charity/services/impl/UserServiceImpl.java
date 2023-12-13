package com.cdp.charity.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdp.charity.entityes.UserInfo;
import com.cdp.charity.repositoryes.UserInfoRepo;
import com.cdp.charity.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserInfoRepo infoRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserInfo saveUser(UserInfo info) {
		info.setPassword(encoder.encode(info.getPassword()));
		return infoRepo.save(info);
	}

}
