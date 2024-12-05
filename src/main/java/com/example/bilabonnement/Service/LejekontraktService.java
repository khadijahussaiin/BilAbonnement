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
}
