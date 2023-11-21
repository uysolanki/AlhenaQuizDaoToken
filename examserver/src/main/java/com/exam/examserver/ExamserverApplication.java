package com.exam.examserver;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.service.UserService;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner{
    @Autowired
	UserService userserv;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code..");
		
		/*User user=new User();
		user.setFirstName("Alhena");
		user.setLastName("Khan");
		user.setUsername("alh123");
		user.setPassword("alh123");
		user.setEmail("al@gmail");
		user.setProfile("def.png");
		user.setPhoneno("123456");
		
		Role r1=new Role();
		r1.setRoleId(44L);
		r1.setRoleName("ADMIN");
		
		
		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole usr=new UserRole();
		usr.setRole(r1);
		usr.setUser(user);
		
		
		
		userRoleSet.add(usr);
		
		User usr1=userserv.createUser(user, userRoleSet);
		System.out.println(usr1.getUsername());*/
	}

}
