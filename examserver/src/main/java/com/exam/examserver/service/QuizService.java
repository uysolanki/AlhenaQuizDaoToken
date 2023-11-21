package com.exam.examserver.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.Category;
import com.exam.examserver.entity.Quiz;
import com.exam.examserver.repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
	private QuizRepository quizrepo;
	
	public Quiz addQuiz(Quiz quiz) {
		return quizrepo.save(quiz);
	}
	public Quiz updateQuiz(Quiz quiz) {
		return quizrepo.save(quiz);
	}
	
	public Set<Quiz> getQuizzes() {
		return new HashSet<>(quizrepo.findAll());
	}
	
	public Optional<Quiz> getQuiz(Long qid) {
		return quizrepo.findById(qid);
	}
	
	public void deleteQuiz(Long qid) {
//		Quiz q=new Quiz();
//		q.setQid(qid);
		quizrepo.deleteById(qid);
	}
	
	public List<Quiz> getQuizOfCat(Category cat) {
		// TODO Auto-generated method stub
		return quizrepo.findByCategory(cat);
		
		
	}
	
	public List<Quiz> getActive(Boolean b){
		return quizrepo.findByActive(true);
	}

	public List<Quiz> getCategoryAndActive(Category c,Boolean b){
		return quizrepo.findByCategoryAndActive(c,true);
	}

}
