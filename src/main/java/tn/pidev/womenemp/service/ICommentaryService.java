package tn.pidev.womenemp.service;

import org.springframework.stereotype.Repository;
import tn.pidev.womenemp.entities.Commentary;

import java.util.List;

public interface ICommentaryService {
    Commentary addCommentary(Commentary c);
    List<Commentary> retrieveAllCommentarys();
    void deleteCommentary (int idCommentary);
    Commentary updateCommentary (Commentary c);
    Commentary retrieveCommentary (int idCommentary);
}
