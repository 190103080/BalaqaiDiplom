package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.TraditionsAndCustomsOfEducation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TraditionsAndCustomersFileUploadService {

    boolean uploadTraditionsAndCustomersImage(MultipartFile file, TraditionsAndCustomsOfEducation traditionsAndCustomsOfEducation);
    byte[] getTraditionsAndCustomerImage(String token) throws IOException;

}
