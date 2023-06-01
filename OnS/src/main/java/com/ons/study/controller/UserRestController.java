package com.ons.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ons.study.dto.UserDTO;
import com.ons.study.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/request-login")
	public ResponseEntity<UserDTO> requestLogin(@RequestBody UserDTO user) {
		if (userService.isMember(user.getEmail(), user.getPassword()) == 1) {
			user.setEmail("");
			user.setPassword("");
			return ResponseEntity.ok().body(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
