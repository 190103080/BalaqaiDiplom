package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.FamilyTraditions;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FamilyTraditionFileUploadService {

    boolean uploadFamilyTraditionsImage(MultipartFile file, FamilyTraditions familyTraditions);
    byte[] getFamilyTraditionsImage(String token) throws IOException;

}
