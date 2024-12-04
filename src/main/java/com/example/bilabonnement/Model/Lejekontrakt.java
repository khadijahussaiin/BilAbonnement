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

    public Lejekontrakt() {
    }

    public Lejekontrakt(int LejekontraktID, String Navn, String Vognnummer, LocalDate StartDato, LocalDate SlutDato, double pris, StatusLK StatusLK) {
        this.LejekontraktID = LejekontraktID;
        this.Navn = Navn;
        this.Vognnummer = Vognnummer;
        this.StartDato = StartDato;
        this.SlutDato = SlutDato;
        this.pris = pris;
        this.StatusLK = StatusLK;
    }

    public int getLejekontraktID() {
        return LejekontraktID;
    }
    public void setLejekontraktID(int LejekontraktID) {
        this.LejekontraktID = LejekontraktID;
    }
    public String getNavn() {
        return Navn;
    }
    public void setNavn(String Navn) {
        this.Navn = Navn;
    }
    public String getVognnummer() {
        return Vognnummer;
    }
    public void setVognnummer(String Vognnummer) {
        this.Vognnummer = Vognnummer;
    }
    public LocalDate getStartDato() {
        return StartDato;
    }
    public void setStartDato(LocalDate StartDato) {
        this.StartDato = StartDato;
    }
    public LocalDate getSlutDato() {
        return SlutDato;
    }
    public void setSlutDato(LocalDate SlutDato){
        this.SlutDato = SlutDato;
    }
    public double getPris() {
        return pris;
    }
    public void setPris(double pris) {
        this.pris = pris;
    }
    public StatusLK getStatusLK() {
        return StatusLK;
    }
}
