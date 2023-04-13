package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.NauryzTraditions;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface NauryzTraditionFileUploadService {

    boolean uploadNauryzTraditionImage(MultipartFile file, NauryzTraditions nauryzTraditions);
    byte[] getNauryzTraditionImage(String token) throws IOException;

}
