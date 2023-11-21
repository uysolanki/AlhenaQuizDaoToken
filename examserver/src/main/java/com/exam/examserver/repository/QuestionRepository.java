package com.exam.examserver.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examserver.entity.Question;
import com.exam.examserver.entity.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
