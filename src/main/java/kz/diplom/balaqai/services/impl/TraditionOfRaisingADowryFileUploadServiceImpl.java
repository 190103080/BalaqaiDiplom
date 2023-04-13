package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.TraditionsOfRaisingADowry;
import kz.diplom.balaqai.services.TraditionsOfRaisingADowryFileUploadService;
import kz.diplom.balaqai.services.TraditionsOfRaisingADowryService;
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
public class TraditionOfRaisingADowryFileUploadServiceImpl implements TraditionsOfRaisingADowryFileUploadService {

    @Autowired
    private TraditionsOfRaisingADowryService traditionsOfRaisingADowryService;

    @Value("${loadTraditionsOfRaisingURL}")
    private String loadTraditionsOfRaisingURL;

    @Value("${uploadTraditionsOfRaisingURL}")
    private String uploadTraditionsOfRaisingURL;

    @Override
    public boolean uploadTraditionsOfRaisingImage(MultipartFile file, TraditionsOfRaisingADowry traditionsOfRaisingADowry) {
        try {
            if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {

                String fileName = DigestUtils.sha1Hex(traditionsOfRaisingADowry.getId() + " image") + ".png";
                byte bytes[] = file.getBytes();
                Path path = Paths.get(uploadTraditionsOfRaisingURL + fileName);
                Files.write(path, bytes);

                traditionsOfRaisingADowry.setImage(fileName);
                traditionsOfRaisingADowryService.saveTraditionOfRaisingADowry(traditionsOfRaisingADowry);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public byte[] getTraditionsOfRaisingImage(String token) throws IOException {
        String picURL = loadTraditionsOfRaisingURL + "image.png";
        if (token != null) {
            if (token.equals(traditionsOfRaisingADowryService.getCurrentTraditionsOfRaising().getImage()))
                picURL = loadTraditionsOfRaisingURL + token;
        }

        InputStream in;

        try {
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        } catch (Exception e) {
            picURL = loadTraditionsOfRaisingURL + "image.png";
            ClassPathResource resource = new ClassPathResource(picURL);
            in = resource.getInputStream();
        }

        return IOUtils.toByteArray(in);
    }
}
