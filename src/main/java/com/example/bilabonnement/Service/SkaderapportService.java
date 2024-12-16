package com.example.bilabonnement.Service;
//Søren og Khadija
import com.example.bilabonnement.Model.Skaderapport;
import com.example.bilabonnement.Repository.SkaderapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkaderapportService {

    @Autowired
    private SkaderapportRepository skaderapportRepository;

    // 1. Service-metode til at hente alle skaderapporter
    public List<Skaderapport> findAll() {
        return skaderapportRepository.fetchAll();
    }
    // 2. Service-metode til at oprette en ny skaderapport
    public void createSkaderapport(String vognnummer, String dato, double overkoerteKilometer, String checkAfSkade, String skadeBeskrivelse, double prisIAlt) {
        skaderapportRepository.saveSkaderapport(vognnummer, dato, overkoerteKilometer, checkAfSkade, skadeBeskrivelse, prisIAlt);
    }
    // 3. Service-metode til at hente en specifik skaderapport
    public Skaderapport getSkaderapportById(int skadeID) {
        return skaderapportRepository.findById(skadeID);
    }

    // 4. Service-metode til at opdatere en skaderapport
    public void updateSkaderapport(int skadeID, String vognnummer, String dato, double overkoerteKilometer, String checkAfSkade, String skadeBeskrivelse, double prisIAlt) {
        skaderapportRepository.updateSkaderapport(skadeID, vognnummer, dato, overkoerteKilometer, checkAfSkade, skadeBeskrivelse, prisIAlt);
    }
    // 5. Service-metode til at slette en skaderapport
    public void deleteSkaderapport(int skadeID) {
        skaderapportRepository.deleteById(skadeID);
    }
    // 6. Service-metode til at søge efter skaderapporter baseret på ID, vognnummer eller CheckAfSkade
    public List<Skaderapport> searchSkaderapport(String searchTerm) {
        return skaderapportRepository.searchByIdOrVognnummerOrCheckAfSkade(searchTerm);
    }
}


