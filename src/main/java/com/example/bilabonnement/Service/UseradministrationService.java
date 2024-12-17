package com.example.bilabonnement.Service;
//Khadija og Bushra
import com.example.bilabonnement.Model.Useradministration;
import com.example.bilabonnement.Repository.UseradministrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseradministrationService {

    @Autowired
    private UseradministrationRepository useradministrationRepository;

    public boolean validateUser(String username, String password) {
        try {
            Useradministration user = useradministrationRepository.findByUsernameAndPassword(username, password);
            return user != null;
        } catch (Exception e) {
            return false;
        }
    }
}

