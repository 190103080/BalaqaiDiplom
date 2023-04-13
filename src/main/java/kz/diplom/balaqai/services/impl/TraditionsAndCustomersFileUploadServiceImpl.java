package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.TraditionsAndCustomsOfEducation;
import kz.diplom.balaqai.services.TraditionsAndCustomersFileUploadService;
import kz.diplom.balaqai.services.TraditionsAndCustomersOfEducationService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class TraditionsAndCustomersFileUploadServiceImpl implements TraditionsAndCustomersFileUploadService {

    @Autowired
    private TraditionsAndCustomersOfEducationService traditionsAndCustomersOfEducationService;

    @Value("${loadTraditionsAndCustomersURL}")
    private String loadTraditionsAndCustomersURL;

    @Value("${uploadTraditionsAndCustomersURL}")
    private String uploadTraditionsAndCustomersURL;

    @Override
    public boolean uploadTraditionsAndCustomersImage(MultipartFile file, TraditionsAndCustomsOfEducation traditionsAndCustomsOfEducation) {
        try {
            if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {

                String fileName = DigestUtils.sha1Hex(traditionsAndCustomsOfEducation.getId() + " image") + ".png";
                byte bytes[] = file.getBytes();
                Path path = Paths.get(uploadTraditionsAndCustomersURL + fileName);
                Files.write(path, bytes);

                traditionsAndCustomsOfEducation.setImage(fileName);
                traditionsAndCustomersOfEducationService.saveTraditionAndCustomersOfEducation(traditionsAndCustomsOfEducation);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public byte[] getTraditionsAndCustomerImage(String token) throws IOException {
        String picURL = loadTraditionsAndCustomersURL + "image.png";
        if (token != null) {
            if (token.equals(traditionsAndCustomersOfEducationService.getCurrentTraditionsAndCustomers().getImage()))
                picURL = loadTraditionsAndCustomersURL + token;
        }

        InputStream in;

        try {
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        } catch (Exception e) {
            picURL = loadTraditionsAndCustomersURL + "image.png";
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        }

        return IOUtils.toByteArray(in);
    }
}
