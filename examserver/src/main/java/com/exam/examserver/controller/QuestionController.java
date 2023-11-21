package com.exam.examserver.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import com.exam.examserver.entity.Question;
import com.exam.examserver.entity.Quiz;
import com.exam.examserver.service.QuestionService;
import com.exam.examserver.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	
	@Autowired
	private QuestionService quesserv;
	
	@Autowired
	private QuizService quizserv;
	
	@PostMapping("/addQuestion")
	public ResponseEntity<?> addQuestion(@RequestBody Question question) {
		 Question q1=quesserv.addQuestion(question);
		 return ResponseEntity.ok(q1);
	}
	
	
	@GetMapping("/getQuesSing/{quesid}")
	public Optional<Question> getQuesSing(@PathVariable("quesid") Long quesid) {
		 
		 return quesserv.getQuestion(quesid);
	}
	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuesOfQuiz(@PathVariable("qid") Long qid) {
		 
		Optional<Quiz> quiz = quizserv.getQuiz(qid);
	       
	        Set<Question> questions = quiz.get().getQuestions();
	        List<Question> list = new ArrayList<>(questions);
	        if (list.size() > Integer.parseInt(quiz.get().getNumberOfQues())) {
	            list = list.subList(0, Integer.parseInt(quiz.get().getNumberOfQues() + 1));
	        }
	        Collections.shuffle(list);
	        return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuesOfQuizAdmin(@PathVariable("qid") Long qid) {
		 Quiz quiz=new Quiz();
		 quiz.setQid(qid);
		 Set<Question> quesOfQuiz=quesserv.getQuestionsOfquiz(quiz);
	        return ResponseEntity.ok(quesOfQuiz);
	}
	
	@PutMapping("/updateQuestion")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
		
		return ResponseEntity.ok(quesserv.updateQuestion(question));
	}
	
	@DeleteMapping("/deleteQuestion/{quesid}")
	public void deleteCategory(@PathVariable("quesid") Long quesid) {
		
		 quesserv.deleteQues(quesid);
	}
	
}
