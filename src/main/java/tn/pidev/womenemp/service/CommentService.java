package tn.pidev.womenemp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pidev.womenemp.entities.Comment;
import tn.pidev.womenemp.entities.Publication;
import tn.pidev.womenemp.repo.CommentRepository;
import tn.pidev.womenemp.repo.PublicationRepository;


import java.util.List;
@Service
public class CommentService implements ICommentService {
    @Autowired
    CommentRepository commentrepository;
    @Autowired
    PublicationRepository publicationrepository;

    @Override
    public List<Comment> retrieveAllComments(){
        List<Comment> comments= (List<Comment>) commentrepository.findAll();
        return comments;
    }

    @Override
    public void addComment(Comment c,Integer idPublication){

        Publication publication=publicationrepository.findById(idPublication).orElse(null);

        c.setPublication(publication);

        commentrepository.save(c);
    }

    @Override
    public void deleteComment(int idComment){ commentrepository.deleteById(idComment);}

    @Override
    public Comment updateComment(Comment c){ return commentrepository.save(c);}

    @Override
    public Comment retrieveComment(int idComment){Comment comment=commentrepository.findById(idComment).orElse(null);
        return comment;}

}
