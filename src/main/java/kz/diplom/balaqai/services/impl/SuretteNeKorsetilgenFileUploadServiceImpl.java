package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.SuretteNeKorsetilgen;
import kz.diplom.balaqai.services.SuretteNeKorsetilgenFileUploadService;
import kz.diplom.balaqai.services.SuretteNeKorsetilgenService;
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
public class SuretteNeKorsetilgenFileUploadServiceImpl implements SuretteNeKorsetilgenFileUploadService {

    @Autowired
    private SuretteNeKorsetilgenService suretteNeKorsetilgenService;

    @Value("${loadSuretteNeKorsetilgenURL}")
    private String loadSuretteNeKorsetilgenURL;

    @Value("${uploadSuretteNeKorsetilgenURL}")
    private String uploadSuretteNeKorsetilgenURL;

    @Override
    public boolean uploadSuretteNeKorsetilgenImage(MultipartFile multipartFile, SuretteNeKorsetilgen suretteNeKorsetilgen) {
        try {
            if (multipartFile.getContentType().equals("image/jpeg") || multipartFile.getContentType().equals("image/png")) {

                String fileName = DigestUtils.sha1Hex(suretteNeKorsetilgen.getId() + " image") + ".png";
                byte bytes[] = multipartFile.getBytes();
                Path path = Paths.get(uploadSuretteNeKorsetilgenURL + fileName);
                Files.write(path, bytes);

                suretteNeKorsetilgen.setImage(fileName);
                suretteNeKorsetilgenService.saveSuretteNeKorsetilgen(suretteNeKorsetilgen);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public byte[] getSuretteNeKorsetilgenImage(String token) throws IOException {
        String picURL = loadSuretteNeKorsetilgenURL + "image.jpg";
        if (token != null) {
            if (token.equals(suretteNeKorsetilgenService.getCurrentType().getImage()))
                picURL = loadSuretteNeKorsetilgenURL + token;
        }

        InputStream in;

        try {
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        } catch (Exception e) {
            picURL = loadSuretteNeKorsetilgenURL + "image.jpg";
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        }

        return IOUtils.toByteArray(in);
    }
}
