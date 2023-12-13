package com.cdp.charity.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdp.charity.dto.AuthReq;
import com.cdp.charity.entityes.UserInfo;
import com.cdp.charity.services.JwtService;
import com.cdp.charity.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/basic")
@RequiredArgsConstructor
public class BasicController {

	private final AuthenticationManager authenticationManager;
	
	private final JwtService jwtService;
	
	private final UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<Map<Object, Object>> saveUser(@RequestBody UserInfo info){
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", userService.saveUser(info));
		map.put("success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthReq authReq) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getName(), authReq.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(authReq.getName());
		}else {
			throw new UsernameNotFoundException(authReq.getName());
		}
	}
}
