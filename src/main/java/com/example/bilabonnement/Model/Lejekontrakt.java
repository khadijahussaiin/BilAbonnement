package com.example.bilabonnement.Model;

import java.time.LocalDate;
public class Lejekontrakt {
    private int LejekontraktID;
    private String Navn;
    private String Vognnummer;
    private LocalDate StartDato; //konverter: Bruge LocalDate i stedet for da det passser i java men DATE passer kun i mysql
    private LocalDate SlutDato;
    private double pris;
    private StatusLK StatusLK;
}
