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

    //1. service vis alle biler
    public List<Bil> findAll() {
        return bilRepository.fetchAllBiler();
    }
    //2. opret bil service
    public void createBil(String vognnummer, String maerke, String stelnummer, int model, Double staalpris,
                          Double regAfgift, Double co2Udledning, String gearType, int tilstandID, String imageUrl) {
        bilRepository.saveBil(vognnummer, maerke, stelnummer, model, staalpris, regAfgift, co2Udledning, gearType, tilstandID, imageUrl);
    }
    //3. updater biler
    public Bil getBilByVognnummer(String vognnummer) {
        return bilRepository.findBilByVognnummer(vognnummer);
    }

    public void updateBil(String vognnummer, String maerke, String stelnummer, int model, Double staalpris,
                          Double regAfgift, Double co2Udledning, String gearType, int tilstandID, String imageUrl) {
        bilRepository.updateBil(vognnummer, maerke, stelnummer, model, staalpris, regAfgift, co2Udledning, gearType, tilstandID, imageUrl);
    }
    //4. Service-metode til at slette en bil
    public void deleteBil(String vognnummer) {
        bilRepository.deleteBil(vognnummer);
    }
    // Service-metode til søgning af biler
    public List<Bil> searchBiler(String searchTerm) {
        return bilRepository.searchBiler(searchTerm);
    }
}



