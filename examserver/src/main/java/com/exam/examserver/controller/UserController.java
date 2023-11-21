package com.exam.examserver.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    
	@Autowired
	UserService userserv;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	//creating user
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) throws Exception {
		
		
		user.setPassword(this.bcrypt.encode(user.getPassword()));
		Set<UserRole> roles=new HashSet<>();
		Role role=new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole usr=new UserRole();
		usr.setRole(role);
		usr.setUser(user);
		
		roles.add(usr);
		return userserv.createUser(user,roles);
		
	}
	
	@GetMapping("/getuser/{username}")
	public User getUser(@PathVariable("username") String username) {
		return userserv.getUser(username);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		 userserv.deleteUser(id);
		 
	}
	
	
	
	//update
	
	
	@PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        return userserv.updateUser(user, id);
    }
}
