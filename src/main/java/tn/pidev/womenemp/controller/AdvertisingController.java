package tn.pidev.womenemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pidev.womenemp.entities.Advertising;
import tn.pidev.womenemp.service.IAdvertisingService;


import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdvertisingController {
    @Autowired
    private IAdvertisingService advertisingservice;

    // http://localhost:8081/SpringMVC/ads/retrieve-all-ads
    @GetMapping("/retrieve-all-ads")
    @ResponseBody
    public List<Advertising> getAdvertisings() {
        List<Advertising> listAdvertisings = advertisingservice.retrieveAllAdvertisings();
        return listAdvertisings;}

    // http://localhost:8081/SpringMVC/ads/add-ads
    @PostMapping("/add-ads")
    @ResponseBody
    public Advertising addAdvertsing(@RequestBody Advertising a){ return advertisingservice.addAdvertising(a); }

    // http://localhost:8081/SpringMVC/ads/remove-ads/{id}
    @DeleteMapping("/remove-ads/{id}")
    @ResponseBody
    public void deleteAdvertising (@PathVariable("id") int idAds){advertisingservice.deleteAdvertising(idAds);}

    // http://localhost:8081/SpringMVC/ads/modify-ads
    @PutMapping("/update-ads")
    @ResponseBody
    public Advertising updateAdvertising(@RequestBody Advertising a){
        return advertisingservice.updateAdvertising(a);
    }

    // http://localhost:8081/SpringMVC/ads/retrieve-ads/{id}
    @GetMapping("/retrieve-ads/{id}")
    @ResponseBody
    public Advertising getAdvertising(@PathVariable("id") int idAdvertising){
        return advertisingservice.retrieveAdvertising(idAdvertising);}

}
