package tn.pidev.womenemp.service;

import tn.pidev.womenemp.entities.Publication;

import java.util.List;

public interface IPublicationService {
    Publication addPublication(Publication p);
    List<Publication> retrieveAllPublications();
    void deletePublication(int idPublication);
    Publication updatePublication(Publication p);
    Publication retrievePublication(int idPublication);
}
