package com.javachinna.service;



import com.javachinna.model.Quiz;

import java.util.List;

public interface IQuizService {
	Quiz addQuiz(Quiz q);
	List<Quiz> retrieveAllQuizes();
	void deleteQuiz(Integer IdQuiz);
	Quiz updateQuiz(Quiz q);
	Quiz retrieveQuiz(Integer IdQuiz);
	void ajouterEtAffecterQuizAFormation(Quiz quiz, Integer idTraining);

}
