package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Lejekontrakt;
import com.example.bilabonnement.Repository.LejekontraktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LejekontraktService {

    @Autowired
    private LejekontraktRepository lejekontraktRepository;
    //1. service vis alle lejekontraker
    public List<Lejekontrakt> getAllLejekontraktInfo() {
        return lejekontraktRepository.fetchAllLejekontraktInfo();
    }
    //2. service opret ny lejekontrakt
    public void createLejekontrakt(String startDato, String slutDato, double pris, String vognnummer,
                                   String navn, String email, String telefon, int statusID) {
        lejekontraktRepository.saveLejekontrakt(startDato, slutDato, pris, vognnummer, navn, email, telefon, statusID);
    }
    //3.Service-metode til at opdatere en eksisterende lejekontrakt
    public void updateLejekontrakt(int lejekontraktID, String startDato, String slutDato, double pris,
                                   String vognnummer, int kundeID, String navn, String email, String telefon, int statusID) {
        lejekontraktRepository.updateLejekontrakt(lejekontraktID, startDato, slutDato, pris, vognnummer, kundeID, navn, email, telefon, statusID);
    }
    // Service-metode til at hente en lejekontrakt baseret på ID
    public Lejekontrakt findLejekontraktById(int lejekontraktID) {
        return lejekontraktRepository.findLejekontraktById(lejekontraktID);
    }
    //4. Service-metode til at slette en lejekontrakt
    public void deleteLejekontrakt(int lejekontraktID) {
        lejekontraktRepository.deleteLejekontrakt(lejekontraktID);
    }
    //5.Service-metode til at søge efter lejekontrakter
    public List<Lejekontrakt> searchLejekontrakter(String soegeord) {
        return lejekontraktRepository.searchLejekontrakter(soegeord);
    }
}
