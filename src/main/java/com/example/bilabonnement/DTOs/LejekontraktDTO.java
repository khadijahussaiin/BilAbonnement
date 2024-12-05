package com.example.bilabonnement.DTOs;

import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Model.Kunde;
import com.example.bilabonnement.Model.Lejekontrakt;

public class LejekontraktDTO {
    private Lejekontrakt lejekontrakt;
    private Kunde kunde;
    private Bil bil;
    public LejekontraktDTO(Lejekontrakt lejekontrakt, Kunde kunde, Bil bil) {
        this.lejekontrakt = lejekontrakt;
        this.kunde = kunde;
        this.bil = bil;
    }

    public Bil getBil() {
        return bil;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Lejekontrakt getLejekontrakt() {
        return lejekontrakt;
    }

    public void setLejekontrakt(Lejekontrakt lejekontrakt) {
        this.lejekontrakt = lejekontrakt;
    }
}

