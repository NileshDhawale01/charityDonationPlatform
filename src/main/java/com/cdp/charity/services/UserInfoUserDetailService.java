package com.cdp.charity.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cdp.charity.config.UserInfoDetails;
import com.cdp.charity.entityes.UserInfo;
import com.cdp.charity.repositoryes.UserInfoRepo;

@Component
public class UserInfoUserDetailService implements UserDetailsService{

	@Autowired
	private UserInfoRepo infoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = infoRepo.findByName(username);
		return userInfo.map(UserInfoDetails::new).orElseThrow(()-> new UsernameNotFoundException(username));
	}
	
	
}
