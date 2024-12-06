package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Repository.BilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilService {

    @Autowired
    private BilRepository bilRepository;

    // Hent alle biler
    public List<Bil> getAllBiler() {
        return bilRepository.fetchAllBiler();
    }

    // Søg efter biler via vognnummer -  bare note til det her tilknyttet søg controlleren
    public List<Bil> searchByVognnummer(String vognnummer) {
        return bilRepository.searchByVognnummer(vognnummer);
    }

    // Tilføjer  ny bil
    public void addBil(Bil bil) {
        bilRepository.addBil(bil);
    }
}
