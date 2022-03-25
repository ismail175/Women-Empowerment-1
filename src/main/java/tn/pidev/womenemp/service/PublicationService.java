package tn.pidev.womenemp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pidev.womenemp.entities.Publication;
import tn.pidev.womenemp.repo.CommentRepository;
import tn.pidev.womenemp.repo.PublicationRepository;

import java.util.List;
@Service
public class PublicationService implements IPublicationService {
    @Autowired
    PublicationRepository publicationrepository;



    public List<Publication> retrieveAllPublications(){
        List<Publication> publications= (List<Publication>) publicationrepository.findAll();
        return publications;
    }
    public Publication addPublication(Publication p){return publicationrepository.save(p);}


    public void deletePublication(int idPublication){
        publicationrepository.deleteById(idPublication);
    }

    public Publication updatePublication(Publication p){
        return publicationrepository.save(p);
    }


    public Publication retrievePublication(int idPublication){
        Publication publication=publicationrepository.findById(idPublication).orElse(null);
        return publication;}
}

