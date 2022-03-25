package tn.pidev.womenemp.repo;

import org.springframework.data.repository.CrudRepository;

import tn.pidev.womenemp.entities.Rating;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
}
