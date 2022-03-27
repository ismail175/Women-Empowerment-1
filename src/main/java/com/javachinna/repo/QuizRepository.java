package com.javachinna.repo;

import com.javachinna.model.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizRepository extends CrudRepository<Quiz, Integer> {

}
