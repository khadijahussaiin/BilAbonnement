package com.example.bilabonnement.Model;

import java.time.LocalDate;
public class Lejekontrakt {
    private int lejekontraktID;
    private String navn;
    private String vognnummer;
    private LocalDate startDato; //konverter: Bruge LocalDate i stedet for da det passser i java men DATE passer kun i mysql
    private LocalDate slutDato;
    private double pris;
    private String statusLK;

    public Lejekontrakt() {
    }

    public Lejekontrakt(int lejekontraktID, String navn, String vognnummer, LocalDate startDato, LocalDate slutDato, double pris, String statusLK) {
        this.lejekontraktID = lejekontraktID;
        this.navn = navn;
        this.vognnummer = vognnummer;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.pris = pris;
        this.statusLK = statusLK;
    }

    public int getLejekontraktID() {
        return lejekontraktID;
    }
    public void setLejekontraktID(int lejekontraktID) {
        this.lejekontraktID = lejekontraktID;
    }
    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public String getVognnummer() {
        return vognnummer;
    }
    public void setVognnummer(String vognnummer) {
        this.vognnummer = vognnummer;
    }
    public LocalDate getStartDato() {
        return startDato;
    }
    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }
    public LocalDate getSlutDato() {
        return slutDato;
    }
    public void setSlutDato(LocalDate slutDato){
        this.slutDato = slutDato;
    }
    public double getPris() {
        return pris;
    }
    public void setPris(double pris) {
        this.pris = pris;
    }
    public String getStatusLK() {
        return statusLK;
    }
    public void setStatusLK(String statusLK) {
        this.statusLK = statusLK;
    }
}
