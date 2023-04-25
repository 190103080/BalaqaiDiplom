package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.AliMenAiya;
import kz.diplom.balaqai.services.AliMenAiyaFileUploadService;
import kz.diplom.balaqai.services.AliMenAiyaService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AliMenAiyaFileUploadServiceImpl implements AliMenAiyaFileUploadService {

    @Autowired
    private AliMenAiyaService aliMenAiyaService;

    @Value("static/aliMenAiyaImage/")
    private String loadAliMenAiyaImage;

    @Value("build/resources/main/static/aliMenAiyaImage/")
    private String uploadAliMenAiyaImage;

    @Override
    public boolean uploadAliMenAiyaImage(MultipartFile multipartFile, AliMenAiya aliMenAiya) {
        try {
            if (multipartFile.getContentType().equals("image/jpeg") || multipartFile.getContentType().equals("image/png")) {
                String fileName = DigestUtils.sha1Hex(aliMenAiya.getId() + "image") + ".png";
                byte bytes[] = multipartFile.getBytes();
                Path path = Paths.get(uploadAliMenAiyaImage + fileName);
                Files.write(path, bytes);

                aliMenAiya.setVariant1(fileName);
                aliMenAiya.setVariant2(fileName);
                aliMenAiya.setVariant3(fileName);
                aliMenAiya.setVariant4(fileName);
                aliMenAiya.setAnswer(fileName);
//                aliMenAiyaService.saveAliMenAiya(aliMenAiya);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public byte[] getAliMenAiyaImage(String token) throws IOException {
        String picURL = loadAliMenAiyaImage + "image.jpg";
        if (token != null) {
//            if (token.equals(aliMenAiyaService.getCurrentAliMenAiya().get))
        }

        return null;
    }
}
