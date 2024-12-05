package com.example.bilabonnement.Model;

import java.time.LocalDate;

public class Skaderapport {
    private int skadeID;
    private String vognnummer;
    private LocalDate dato;//konverter til java datatype
    private double overkoerteKilometer;
    private String checkAfSkade;
    private String skadeBeskrivelse;
    private double prisIAlt;
}
