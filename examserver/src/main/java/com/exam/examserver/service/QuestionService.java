package com.exam.examserver.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.Question;
import com.exam.examserver.entity.Quiz;
import com.exam.examserver.repository.QuestionRepository;

@Service
public class QuestionService {
    @Autowired
	private QuestionRepository quesrepo;
	
	public Question addQuestion(Question question) {
		return quesrepo.save(question);
	}
	
	public Question updateQuestion(Question question) {
		return quesrepo.save(question);
	}
	
	public Set<Question> getQuestions() {
		return new HashSet<>(quesrepo.findAll());
	}
	
	public Optional<Question> getQuestion(Long quesid) {
		return quesrepo.findById(quesid);
	}
	
	public Set<Question> getQuestionsOfquiz(Quiz quiz) {
		return quesrepo.findByQuiz(quiz);
	}
	
	public void deleteQues(Long quesid) {
		quesrepo.deleteById(quesid);
	}
}
