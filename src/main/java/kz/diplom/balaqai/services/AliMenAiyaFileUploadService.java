package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.AliMenAiya;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AliMenAiyaFileUploadService {

        boolean uploadAliMenAiyaImage(MultipartFile multipartFile, AliMenAiya aliMenAiya);
        byte[] getAliMenAiyaImage(String token) throws IOException;

}
