package com.example.bilabonnement.Model;

import java.time.LocalDate;

public class Skaderapport {
    private int SkadeID;
    private String Vognnummer;
    private LocalDate Dato;//konverter til java datatype
    private double OverkoerteKilometer;
    private String CheckAfSkade;
    private String SkadeBeskrivelse;
    private double PrisIAlt;
}
