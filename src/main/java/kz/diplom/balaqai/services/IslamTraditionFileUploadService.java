package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.IslamTraditions;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IslamTraditionFileUploadService {

    boolean uploadIslamTraditionsImage(MultipartFile file, IslamTraditions islamTraditions);
    byte[] getIslamTraditionsImage(String token) throws IOException;

}
