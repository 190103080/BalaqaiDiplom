package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.SuretteNeKorsetilgen;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface SuretteNeKorsetilgenFileUploadService {

    boolean uploadSuretteNeKorsetilgenImage(MultipartFile multipartFile, SuretteNeKorsetilgen suretteNeKorsetilgen);
    byte[] getSuretteNeKorsetilgenImage(String token) throws IOException;

}
