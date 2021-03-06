package com.javachinna.service;

import com.google.zxing.WriterException;
import com.javachinna.model.Abonement;
import org.springframework.data.repository.query.Param;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface AbonnementService {
    List<Abonement> retrieveAllSubscriptions();

    Abonement addSubscription(Abonement s);

    void deleteSubscription(Long id);

    Abonement updateSubscription(Abonement s);

    Abonement retrieveSubscription(Long id);

    void assignSubscriptionToUser(Long id_subs, Long id_user);

    List<Object> nbrAbonementByLevel();

    void generateQRCodeImage(String url, int width, int height, String filePath) throws WriterException, IOException;
}
