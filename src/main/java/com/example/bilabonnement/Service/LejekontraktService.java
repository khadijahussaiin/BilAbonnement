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
    //service til at vise alle lejekontrakter
    public List<Lejekontrakt> getAllLejekontrakter() {
        return lejekontraktRepository.fetchAllLejekontrakter();
    }
    // Service til at oprette en ny lejekontrakt
    public void opretLejekontrakt(Lejekontrakt lejekontrakt) {
        lejekontraktRepository.opretLejekontrakt(lejekontrakt);
    }
}

