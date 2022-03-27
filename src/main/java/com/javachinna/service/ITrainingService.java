package com.javachinna.service;



import com.javachinna.model.Training;

import java.util.List;

public interface ITrainingService {
	Training addTraining(Training t);
	List<Training> retrieveAllTrainings();
	void deleteTraining(Integer IdTraining);
	Training updateTrainning(Training t);
	Training retrieveTraining(Integer IdTraining);
	void affecterApprenantFormation(Integer idUser,Integer IdTraining);
	Integer getRevenueByFormation(Integer idTraining);

}
