package com.project.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.quiz.model.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

}
