package tn.pidev.womenemp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import tn.pidev.womenemp.entities.Publication;
import tn.pidev.womenemp.service.IPublicationService;


import java.util.List;
@RestController
@RequestMapping("/publication")
public class PublicationController {
    @Autowired

    private IPublicationService publicationservice;

    // http://localhost:8081/SpringMVC/publication/retrieve-all-publication
    @GetMapping("/retrieve-all-publication")
    @ResponseBody
    public List<Publication> getPublications() {
        List<Publication> listPublications = publicationservice.retrieveAllPublications();
        return listPublications;}

    // http://localhost:8081/SpringMVC/publication/add-publication
    @PostMapping("/add-publication")
    @ResponseBody
    public Publication addPublication(@RequestBody Publication p){ return publicationservice.addPublication(p); }

    // http://localhost:8081/SpringMVC/publication/remove-publication/{id}
    @DeleteMapping("/remove-publication/{id}")
    @ResponseBody
    public void deletePublication (@PathVariable("id") int idPublication){publicationservice.deletePublication(idPublication);}

    // http://localhost:8081/SpringMVC/publication/modify-publication
    @PutMapping("/modify-publication")
    @ResponseBody
    public Publication updatePublication(@RequestBody Publication p){
        return publicationservice.updatePublication(p);
    }

    // http://localhost:8081/SpringMVC/publication/retrieve-publication/{id}
    @GetMapping("/retrieve-publication/{id}")
    @ResponseBody
    public Publication getPublication(@PathVariable("id") int idPublication){
        return publicationservice.retrievePublication(idPublication);}
}
