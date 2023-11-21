package com.exam.examserver.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.entity.Category;
import com.exam.examserver.entity.Quiz;
import com.exam.examserver.service.QuizService;



@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizserv;
	
	@PostMapping("/addQuiz")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {
		 Quiz q1=quizserv.addQuiz(quiz);
		 return ResponseEntity.ok(q1);
	}
	
	
	@GetMapping("/getQuiz/{qid}")
	public Optional<Quiz> getQuiz(@PathVariable("qid") Long qid) {
		 
		 return quizserv.getQuiz(qid);
	}
	
	@GetMapping("/getQuizzes")
	public Set<Quiz> getQuizzes() {
		 
		 return quizserv.getQuizzes();
	}
	
	@PutMapping("/updateQuiz")
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		
		return quizserv.updateQuiz(quiz);
	}
	
	 @DeleteMapping("/delQ/{qid}")
	    public void deleteQuiz(@PathVariable("qid") Long qid) {
	        quizserv.deleteQuiz(qid);
	        System.out.println("deleted quiz");
	    }
	 
	 @GetMapping("/category/{cid}")
		public List<Quiz> getQuizOfCat(@PathVariable("cid") Long cid) {
			Category cat=new Category();
			cat.setCid(cid);
			return quizserv.getQuizOfCat(cat);
		}
	 @GetMapping("/active")
	 public List<Quiz> getActive(Boolean b){
			return quizserv.getActive(b);
		}
        
	 @GetMapping("/category/active/{cid}")
		public List<Quiz> getCategoryAndActive(@PathVariable("cid") Long cid,Boolean b){
		 
		Category cat= new Category();
		cat.setCid(cid);
			return quizserv.getCategoryAndActive(cat,b);
		}
}
