package com.example.bilabonnement.Service;
//Søren
import com.example.bilabonnement.Repository.UdlejeværdiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UdlejeværdiService {
    @Autowired
    UdlejeværdiRepository udlejeVærdiRepo;

    public Map<String, Object> getSumAntalogPris() {
       return udlejeVærdiRepo.totalSum();
    }
}
