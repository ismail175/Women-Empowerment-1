package tn.pidev.womenemp.service;

import tn.pidev.womenemp.entities.Advertising;


import java.util.List;

public interface IAdvertisingService {
    Advertising addAdvertising(Advertising a);
    List<Advertising> retrieveAllAdvertisings();
    void deleteAdvertising (int idAds);
    Advertising updateAdvertising (Advertising c);
    Advertising retrieveAdvertising (int idAds);
}
