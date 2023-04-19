package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.FamilyTraditions;
import kz.diplom.balaqai.services.FamilyTraditionFileUploadService;
import kz.diplom.balaqai.services.FamilyTraditionsService;
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
public class FamilyTraditionFileUploadServiceImpl implements FamilyTraditionFileUploadService {

    @Autowired
    private FamilyTraditionsService familyTraditionsService;

    @Value("${loadFamilyURL}")
    private String loadFamilyURL;

    @Value("${uploadFamilyURL}")
    private String uploadFamilyURL;

    @Override
    public boolean uploadFamilyTraditionsImage(MultipartFile file, FamilyTraditions familyTraditions) {
        try {
            if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {

                String fileName = DigestUtils.sha1Hex(familyTraditions.getId() + " image") + ".png";
                byte bytes[] = file.getBytes();
                Path path = Paths.get(uploadFamilyURL + fileName);
                Files.write(path, bytes);

                familyTraditions.setImage(fileName);
                familyTraditionsService.saveFamilyTradition(familyTraditions);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public byte[] getFamilyTraditionsImage(String token) throws IOException {
        String picURL = loadFamilyURL + "image.jpg";
        if (token != null) {
            if (token.equals(familyTraditionsService.getCurrentTradition().getImage()))
                picURL = loadFamilyURL + token;
        }

        InputStream in;

        try {
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        } catch (Exception e) {
            picURL = loadFamilyURL + "image.jpg";
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        }

        return IOUtils.toByteArray(in);
    }
}
