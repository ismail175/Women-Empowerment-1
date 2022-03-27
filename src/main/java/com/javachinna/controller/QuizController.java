package com.javachinna.controller;

import com.javachinna.model.Quiz;
import com.javachinna.service.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	IQuizService quizservice;
	
	// http://localhost:8080/SpringMVC/quiz/retrieve-all-quiz
	@GetMapping("/retrieve-all-quiz")
	@ResponseBody
	public List<Quiz> getQuizes() {
		List<Quiz> quizes = quizservice.retrieveAllQuizes();
		return quizes;
	}
	
	// http://localhost:8080/SpringMVC/quiz/add-quiz
	@PostMapping("/add-quiz")
	@ResponseBody
	public Quiz addQuiz(@RequestBody Quiz q){
		return quizservice.addQuiz(q);
	}
	
	// http://localhost:8080/SpringMVC/quiz/remove-quiz/{id}
	@DeleteMapping("/remove-quiz/{id}")
	@ResponseBody
	public void deletetraining(@PathVariable("id") Integer IdQuiz){
		quizservice.deleteQuiz(IdQuiz);
	}
	
	// http://localhost:8080/SpringMVC/quiz/modify-quiz
	@PutMapping("/modify-quiz")
	@ResponseBody
	public Quiz modifiertraining(@RequestBody Quiz q){
		return quizservice.updateQuiz(q);
	}
	
	// http://localhost:8080/SpringMVC/quiz/retrieve-quiz/{id}
	@GetMapping("/retrieve-quiz/{id}")
	@ResponseBody
	public Quiz getTraining(@PathVariable("id") Integer IdQuiz){
		return quizservice.retrieveQuiz(IdQuiz);		
	}

	//  http://localhost:8080/SpringMVC/quiz/ajouterEtAffecterQuizAFormation/{id}
	@PostMapping("/ajouterEtAffecterQuizAFormation/{id}")
	@ResponseBody
	public void ajouterEtAffecterQuizAFormation(@RequestBody Quiz quiz, @PathVariable("id") Integer idTraining){

		quizservice.ajouterEtAffecterQuizAFormation(quiz,idTraining);


	}
		
		

}
