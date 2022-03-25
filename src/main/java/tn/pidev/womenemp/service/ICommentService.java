package tn.pidev.womenemp.service;

import tn.pidev.womenemp.entities.Comment;

import java.util.List;

public interface ICommentService {
    void addComment (Comment c,Integer idPublication);
    List<Comment> retrieveAllComments();
    void deleteComment (int idComment);
    Comment updateComment (Comment c);
    Comment retrieveComment (int idComment);
}
