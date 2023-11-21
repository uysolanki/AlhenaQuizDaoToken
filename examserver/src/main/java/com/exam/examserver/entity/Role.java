package com.exam.examserver.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {

	@Id
	private Long roleId;
	
	private String roleName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "role")
	private Set<UserRole> userRoles=new HashSet<>();
}
