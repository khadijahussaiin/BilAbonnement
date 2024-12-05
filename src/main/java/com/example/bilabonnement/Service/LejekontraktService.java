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

    public List<Lejekontrakt> getAllLejekontrakter() {
        return lejekontraktRepository.findAllLejekontrakter();
    }

    // Eksempel på en metode til at finde en lejekontrakt efter ID
    public Lejekontrakt getLejekontraktById(int id) {
        // Her kan du tilføje logik til at finde en lejekontrakt ved ID
        // return lejekontraktRepository.findById(id).orElse(null);
        return null; // Juster denne return statement baseret på din repository metode
    }

    // Tilføj flere metoder efter behov
}
