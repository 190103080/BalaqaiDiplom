package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.IslamTraditions;
import kz.diplom.balaqai.services.IslamTraditionFileUploadService;
import kz.diplom.balaqai.services.IslamTraditionsService;
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
public class IslamTraditionFileUploadServiceImpl implements IslamTraditionFileUploadService {

    @Autowired
    private IslamTraditionsService islamTraditionsService;

    @Value("${loadIslamURL}")
    private String loadIslamURL;

    @Value("${uploadIslamURL}")
    private String uploadIslamURL;

    @Override
    public boolean uploadIslamTraditionsImage(MultipartFile file, IslamTraditions islamTraditions) {
        try {
            if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {

                String fileName = DigestUtils.sha1Hex(islamTraditions.getId() + " image") + ".png";
                byte bytes[] = file.getBytes();
                Path path = Paths.get(uploadIslamURL + fileName);
                Files.write(path, bytes);

                islamTraditions.setImage(fileName);
                islamTraditionsService.saveIslamTradition(islamTraditions);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public byte[] getIslamTraditionsImage(String token) throws IOException {
        String picURL = loadIslamURL + "image.png";
        if (token != null) {
            if (token.equals(islamTraditionsService.getCurrentIslamTradition().getImage()))
                picURL = loadIslamURL + token;
        }

        InputStream in;

        try {
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        } catch (Exception e) {
            picURL = loadIslamURL + "image.png";
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        }

        return IOUtils.toByteArray(in);
    }
}
