package tn.pidev.womenemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pidev.womenemp.entities.Comment;
import tn.pidev.womenemp.entities.Rating;
import tn.pidev.womenemp.service.ICommentService;
import tn.pidev.womenemp.service.IRatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private IRatingService ratingservice;

    // http://localhost:8081/SpringMVC/rating/add-rating
    @PostMapping("/add-rating/{idPublication}")
    @ResponseBody
    public void addRating(@RequestBody Rating rating, @PathVariable ("idPublication") Integer idPublication)
    {ratingservice.addRating(rating,idPublication);}
}
