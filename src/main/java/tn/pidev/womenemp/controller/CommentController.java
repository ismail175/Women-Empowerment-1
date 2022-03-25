package tn.pidev.womenemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pidev.womenemp.entities.Comment;
import tn.pidev.womenemp.service.ICommentService;


import java.util.List;
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired


    private ICommentService commentservice;

    // http://localhost:8081/SpringMVC/comment/retrieve-all-comment
    @GetMapping("/retrieve-all-comment")
    @ResponseBody
    public List<Comment> getComments() {
        List<Comment> listComments = commentservice.retrieveAllComments();
        return listComments;}

    // http://localhost:8081/SpringMVC/comment/add-comment
    @PostMapping("/add-comment/{idPublication}")
    @ResponseBody
    public void addComment(@RequestBody Comment c, @PathVariable ("idPublication") Integer idPublication)
     {commentservice.addComment(c,idPublication);}

    // http://localhost:8081/SpringMVC/comment/remove-comment/{id}
    @DeleteMapping("/remove-comment/{id}")
    @ResponseBody
    public void deleteComment (@PathVariable("id") int idComment){commentservice.deleteComment(idComment);}

    // http://localhost:8081/SpringMVC/comment/modify-comment
    @PutMapping("/modify-comment")
    @ResponseBody
    public Comment updateComment(@RequestBody Comment c){
        return commentservice.updateComment(c);
    }

    // http://localhost:8081/SpringMVC/comment/retrieve-comment/{id}
    @GetMapping("/retrieve-comment/{id}")
    @ResponseBody
    public Comment getComment(@PathVariable("id") int idComment){
        return commentservice.retrieveComment(idComment);}
}
