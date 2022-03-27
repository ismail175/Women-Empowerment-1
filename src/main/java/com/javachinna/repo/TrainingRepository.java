package com.javachinna.repo;

import com.javachinna.model.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {

}
