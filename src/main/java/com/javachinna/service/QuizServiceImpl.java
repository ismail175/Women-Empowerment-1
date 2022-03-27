package com.javachinna.service;

import com.javachinna.model.Quiz;
import com.javachinna.model.Training;
import com.javachinna.repo.QuizRepository;
import com.javachinna.repo.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("IQuizService")
public class QuizServiceImpl implements IQuizService{
	
	@Autowired
	QuizRepository quizrepository;

	@Autowired
	TrainingRepository trainingRepository;
	
	public Quiz retrieveQuiz(Integer IdQuiz){
		Quiz quiz=quizrepository.findById(IdQuiz).orElse(null);
		return quiz;
	}

	public Quiz addQuiz(Quiz q) {
		return quizrepository.save(q);
	}

	
	public List<Quiz> retrieveAllQuizes() {
		List<Quiz> quizes= (List<Quiz>) quizrepository.findAll();
		return quizes;
	}

	
	public void deleteQuiz(Integer IdQuiz) {
		quizrepository.deleteById(IdQuiz);
		
	}

	
	public Quiz updateQuiz(Quiz q) {
		return quizrepository.save(q);
	}

	@Override
	public void ajouterEtAffecterQuizAFormation(Quiz quiz, Integer idTraining){

		Training training = trainingRepository.findById(idTraining).orElse(null);
		quiz.setTraining(training);
		quizrepository.save(quiz);

	}
	

}
