package tn.pidev.womenemp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pidev.womenemp.entities.Publication;
import tn.pidev.womenemp.entities.Rating;
import tn.pidev.womenemp.repo.CommentRepository;
import tn.pidev.womenemp.repo.PublicationRepository;
import tn.pidev.womenemp.repo.RatingRepository;

@Service
public class RatingService implements IRatingService{
    @Autowired
    RatingRepository ratingrepository;
    @Autowired
    PublicationRepository publicationrepository;

    @Override
    public void addRating(Rating rating, Integer idPublication){

        Publication publication=publicationrepository.findById(idPublication).orElse(null);

        rating.setPublication(publication);

        ratingrepository.save(rating);
    }
}
