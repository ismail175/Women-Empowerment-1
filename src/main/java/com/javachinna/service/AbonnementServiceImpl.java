package com.javachinna.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.javachinna.model.Abonement;
import com.javachinna.model.User;
import com.javachinna.repo.AbonementRepository;
import com.javachinna.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AbonnementServiceImpl implements AbonnementService{

    @Autowired
    AbonementRepository abonementRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Abonement> retrieveAllSubscriptions() {
        List<Abonement> subscriptions = new ArrayList<> ();
        abonementRepository.findAll().forEach(s -> subscriptions.add(s));
        for (Abonement s : subscriptions) {
            log.info("subscription " + s);

        }
        return subscriptions;
    }

    @Override
    public Abonement addSubscription(Abonement s) {
        return  abonementRepository.save(s);
    }

    @Override
    public void deleteSubscription(Long id) {
        abonementRepository.deleteById(id);
    }

    @Override
    public Abonement updateSubscription(Abonement s) {
        return abonementRepository.save(s);
    }

    @Override
    public Abonement retrieveSubscription(Long id) {
        Abonement abonement = abonementRepository.findById(id).orElse(null);
        return abonement;
    }
    @Override
    public void assignSubscriptionToUser(Long id_subs, Long id_user) {
        User u = userRepository.findById(id_user).orElse(null);
        Abonement abon = abonementRepository.findById (id_subs).orElse (null);
        abon.getUsers ().add(u);
        abonementRepository.save (abon);
    }



    @Override
    public List<Object> nbrAbonementByLevel() {

        List<Object> stat = new ArrayList<> () ;

        LocalDate currentdDate1 = LocalDate.of (2022,1,1);
        Date date = new Date ();

        boolean status = false;


        ZoneId defaultZoneId = ZoneId.systemDefault ();

        Date dd = Date.from (currentdDate1.minusDays (15).atStartOfDay (defaultZoneId).toInstant ());
        Date df = Date.from (currentdDate1.plusDays (15).atStartOfDay (defaultZoneId).toInstant ());

        for (int i=1;i<=12;i++){
            Date ddd = Date.from (currentdDate1.plusMonths (i).atStartOfDay (defaultZoneId).toInstant ());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(ddd);
            Calendar calLast = Calendar.getInstance();
            Calendar calFirst = calendar;
            calLast.set (Calendar.DATE, calendar.getActualMaximum (Calendar.DATE));
            calFirst.set (Calendar.DATE, calendar.getActualMinimum (Calendar.DATE));

            Date lastDayOfMonth = calLast.getTime ();
            Date firstDayOfMonth = calFirst.getTime ();


            stat.add(abonementRepository.nbrAbonementByLevel (firstDayOfMonth,lastDayOfMonth));
        }

        return stat;
    }

    public void generateQRCodeImage(String url, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
