package com.javachinna.controller;

import com.javachinna.model.Abonement;
import com.javachinna.model.User;
import com.javachinna.repo.AbonementRepository;
import com.javachinna.service.AbonnementService;
import com.javachinna.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRCodeController {

    private static String codeText;
    private static String codeTextx = "";
    private static String code2 = "";

    @Autowired
    private AbonementRepository abonementRepository;

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";
    private static final String GOLD_IMAGE_PATH = "";
    private static final String SILVER_IMAGE_PATH = "";
    private static final String BRONZE_IMAGE_PATH = "";

    public static String getImagePath()  {


        if ( codeText == SILVER_IMAGE_PATH){

            codeTextx = SILVER_IMAGE_PATH;
        }
        else if (codeText == BRONZE_IMAGE_PATH)
        {
            codeTextx = BRONZE_IMAGE_PATH;
        }
        else{
            codeTextx = GOLD_IMAGE_PATH;
        }
        return codeTextx; }




    @GetMapping(value = "/genrateAndDownloadQRCode/{codeTextx}/{width}/{height}")
    public void download(
            @PathVariable("codeTextx") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {
        QRCodeGenerator.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
    }

    @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
    @ResponseBody
    public ResponseEntity<byte[]> generateQRCode(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText, width, height));
    }




}
