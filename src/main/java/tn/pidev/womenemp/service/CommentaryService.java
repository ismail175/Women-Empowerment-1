package tn.pidev.womenemp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pidev.womenemp.entities.Commentary;
import tn.pidev.womenemp.repo.CommentaryRepository;

import java.util.List;
@Service
public class CommentaryService implements ICommentaryService {
    @Autowired
    CommentaryRepository commentaryrepository;


    public List<Commentary> retrieveAllCommentarys(){
        List<Commentary> commentarys= (List<Commentary>) commentaryrepository.findAll();
        return commentarys;
    }
    public Commentary addCommentary(Commentary c){ return commentaryrepository.save(c);}

    public void deleteCommentary(int idCommentary){ commentaryrepository.deleteById(idCommentary);}

    public Commentary updateCommentary(Commentary c){ return commentaryrepository.save(c);}


    public Commentary retrieveCommentary(int idCommentary){
        Commentary commentary=commentaryrepository.findById(idCommentary).orElse(null);
        return commentary;}
}
