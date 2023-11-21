package com.exam.examserver.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.repository.UserRepository;


@Service
public class UserService {
    @Autowired
	UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    
	 public User createUser(User user, Set<UserRole> userRoles) throws Exception {
	        User local = this.userRepository.findByUsername(user.getUsername());
	        if (local != null) {
	            System.out.println("User already exists");
	            throw new Exception("user with this username already exists");

	        } else {

	            for (UserRole ur : userRoles) {
	                roleRepository.save(ur.getRole());
	            }
	            user.getUserRoles().addAll(userRoles);
	            local = this.userRepository.save(user);
	        }
	        return local;
	    }

	public User getUser(String username) {
		
		return userRepository.findByUsername(username);
	}

	public void deleteUser(Long id) {
		
		 userRepository.deleteById(id);
	}

	public User updateUser(User user, Long id) {
		Optional<User> usdb=userRepository.findById(id);
		User userch=usdb.get();
		userch.setUsername(user.getUsername());
		return userRepository.save(userch);
	}

	
}
