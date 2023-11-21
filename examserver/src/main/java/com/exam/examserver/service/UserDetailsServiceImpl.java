package com.exam.examserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.User;
import com.exam.examserver.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = this.userRepository.findByUsername(username);
	        if (user == null) {
	            System.out.println("user not found");
	            throw new UsernameNotFoundException("no user found");
	        }

	        return user;
	    }

}
