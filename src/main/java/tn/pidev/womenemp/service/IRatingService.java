package tn.pidev.womenemp.service;

import tn.pidev.womenemp.entities.Rating;

public interface IRatingService {
    void addRating(Rating rating, Integer idPublication);
}
