package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.TraditionsOfRaisingADowry;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TraditionsOfRaisingADowryFileUploadService {

    boolean uploadTraditionsOfRaisingImage(MultipartFile file, TraditionsOfRaisingADowry traditionsOfRaisingADowry);
    byte[] getTraditionsOfRaisingImage(String token) throws IOException;

}
