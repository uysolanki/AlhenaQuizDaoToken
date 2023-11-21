package com.exam.examserver.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long qid;
    
    private String title;
    
    @Column(length = 5000)
    private String description;
    
    private String maxMarks;
    
    private String numberOfQues;
    
    private boolean active=false;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private Category category;
    
    @OneToMany(mappedBy = "quiz",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<Question> questions=new HashSet<>();
    
    
}
