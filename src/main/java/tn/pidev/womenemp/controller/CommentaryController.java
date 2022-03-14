package tn.pidev.womenemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pidev.womenemp.entities.Commentary;
import tn.pidev.womenemp.service.ICommentaryService;


import java.util.List;
@RestController
@RequestMapping("/commentary")
public class CommentaryController {
    @Autowired


    private ICommentaryService commentaryservice;

    // http://localhost:8081/SpringMVC/commentary/retrieve-all-commentary
    @GetMapping("/retrieve-all-commentary")
    @ResponseBody
    public List<Commentary> getCommentarys() {
        List<Commentary> listCommentarys = commentaryservice.retrieveAllCommentarys();
        return listCommentarys;}

    // http://localhost:8081/SpringMVC/commentary/add-commentary
    @PostMapping("/add-commentary")
    @ResponseBody
    public Commentary addCommentary(@RequestBody Commentary c){ return commentaryservice.addCommentary(c); }

    // http://localhost:8081/SpringMVC/commentary/remove-commentary/{id}
    @DeleteMapping("/remove-commentary/{id}")
    @ResponseBody
    public void deleteCommentary (@PathVariable("id") int idCommentary){commentaryservice.deleteCommentary(idCommentary);}

    // http://localhost:8081/SpringMVC/commentary/modify-commentary
    @PutMapping("/modify-commentary")
    @ResponseBody
    public Commentary updateCommentary(@RequestBody Commentary c){
        return commentaryservice.updateCommentary(c);
    }

    // http://localhost:8081/SpringMVC/commentary/retrieve-commentary/{id}
    @GetMapping("/retrieve-commentary/{id}")
    @ResponseBody
    public Commentary getCommentary(@PathVariable("id") int idCommentary){
        return commentaryservice.retrieveCommentary(idCommentary);}
}
