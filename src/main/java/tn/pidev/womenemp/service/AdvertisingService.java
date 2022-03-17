package tn.pidev.womenemp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pidev.womenemp.entities.Advertising;
import tn.pidev.womenemp.repo.AdvertisingRepository;


import java.util.List;
@Service
public class AdvertisingService implements IAdvertisingService  {
    @Autowired


    AdvertisingRepository advertisingrepository;

    public List<Advertising> retrieveAllAdvertisings(){
        List<Advertising> advertisings= (List<Advertising>) advertisingrepository.findAll();
        return advertisings;}
    public Advertising addAdvertising(Advertising a){ return advertisingrepository.save(a);}

    public void deleteAdvertising(int idAds){ advertisingrepository.deleteById(idAds);}

    public Advertising updateAdvertising(Advertising a){ return advertisingrepository.save(a);}


    public Advertising retrieveAdvertising(int idAds){
        Advertising advertising=advertisingrepository.findById(idAds).orElse(null);
        return advertising;}

}
