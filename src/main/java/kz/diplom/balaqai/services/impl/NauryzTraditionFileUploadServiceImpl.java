package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.NauryzTraditions;
import kz.diplom.balaqai.services.NauryzTraditionFileUploadService;
import kz.diplom.balaqai.services.NauryzTraditionsService;
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
public class NauryzTraditionFileUploadServiceImpl implements NauryzTraditionFileUploadService {

    @Autowired
    private NauryzTraditionsService nauryzTraditionsService;

    @Value("${loadNauryzURL}")
    private String loadNauryzURlL;

    @Value("${uploadNauryzURL}")
    private String uploadNauryzURL;

    @Override
    public boolean uploadNauryzTraditionImage(MultipartFile file, NauryzTraditions nauryzTraditions) {
        try {
            if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {

                String fileName = DigestUtils.sha1Hex(nauryzTraditions.getId() + " image") + ".png";
                byte bytes[] = file.getBytes();
                Path path = Paths.get(uploadNauryzURL + fileName);
                Files.write(path, bytes);

                nauryzTraditions.setImage(fileName);
                nauryzTraditionsService.saveNauryzTradition(nauryzTraditions);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public byte[] getNauryzTraditionImage(String token) throws IOException {
        String picURL = loadNauryzURlL + "image.png";
        if (token != null) {
            if (token.equals(nauryzTraditionsService.getCurrentNauryzTradition().getImage()))
                picURL = loadNauryzURlL + token;
        }

        InputStream in;

        try {
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        } catch (Exception e) {
            picURL = loadNauryzURlL + "image.png";
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        }

        return IOUtils.toByteArray(in);
    }
}
