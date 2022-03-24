package com.javachinna.controller;

import com.javachinna.model.Abonement;
import com.javachinna.model.User;
import com.javachinna.repo.AbonementRepository;
import com.javachinna.repo.UserRepository;
import com.javachinna.service.AbonnementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abonement")
public class AbonementController {
    @Autowired
    AbonnementService abonnementService;

    @GetMapping("/sub/allsubscriptions")
    private List<Abonement> getAllSubscriptions() {
        return abonnementService.retrieveAllSubscriptions ();
    }

    @GetMapping("/retrieveSubscription/{id_abonemment}")
    @ResponseBody
    public Abonement retrieveSubscription(@PathVariable("id_abonemment") Long id_abonemment) {
        return abonnementService.retrieveSubscription (id_abonemment);
    }

    @PostMapping("/sub/addsubscriptions")
    private Abonement saveSubscription(@RequestBody Abonement abonement) {
        Abonement savedAbonement = abonnementService.addSubscription (abonement);
        return savedAbonement;
    }

    @PutMapping("/sub/modifysubscriptions/{id_abonemment}")
    private Abonement updateSubscription(@RequestBody Abonement abonement) {
        Abonement updatedSubscription = abonnementService.updateSubscription (abonement);
        return updatedSubscription;
    }

    @DeleteMapping("/deleteSubscription/{id_abonemment}")
    @ResponseBody
    public void deleteSubscription(@PathVariable("id_abonemment") Long id_abonemment) {
        abonnementService.deleteSubscription (id_abonemment);
    }

    @GetMapping("/assignSubscriptionToUser/{id_abonemment}/{id_user}")
    @ResponseBody
    public void assignSubscriptionToUser(@PathVariable("id_abonemment") Long id_abonemment, @PathVariable("id_user") Long id_user) {
        abonnementService.assignSubscriptionToUser (id_abonemment, id_user);
    }

    @ApiOperation(value = "abonementByLevel")
    @GetMapping("/abonementByLevel")
    public List<Object> nbrAbonementByLevel() {
        return abonnementService.nbrAbonementByLevel ();
    }

}
