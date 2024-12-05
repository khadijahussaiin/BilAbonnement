package com.example.bilabonnement.Model;

import java.time.LocalDate;

public class Lejekontrakt {
    private int lejekontraktID;
    private String imageurl;
    private LocalDate startDato;
    private LocalDate slutDato;
    private double pris;
    private String vognnummer;
    private String kundeNavn;
    private String kundeEmail;
    private String kundeTelefon;
    private String status;

    public Lejekontrakt() {
    }
    public Lejekontrakt(int lejekontraktID, String imageurl, LocalDate startDato, LocalDate slutDato, double pris, String vognnummer, String kundeNavn, String kundeEmail, String kundeTelefon, String status) {
        this.lejekontraktID = lejekontraktID;
        this.imageurl = imageurl;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.pris = pris;
        this.vognnummer = vognnummer;
        this.kundeNavn = kundeNavn;
        this.kundeEmail = kundeEmail;
        this.kundeTelefon = kundeTelefon;
        this.status = status;
    }
    // Getters and Setters
    public int getLejekontraktID() {
        return lejekontraktID;
    }

    public void setLejekontraktID(int lejekontraktID) {
        this.lejekontraktID = lejekontraktID;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
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

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getVognnummer() {
        return vognnummer;
    }

    public void setVognnummer(String vognnummer) {
        this.vognnummer = vognnummer;
    }

    public String getKundeNavn() {
        return kundeNavn;
    }

    public void setKundeNavn(String kundeNavn) {
        this.kundeNavn = kundeNavn;
    }

    public String getKundeEmail() {
        return kundeEmail;
    }

    public void setKundeEmail(String kundeEmail) {
        this.kundeEmail = kundeEmail;
    }

    public String getKundeTelefon() {
        return kundeTelefon;
    }

    public void setKundeTelefon(String kundeTelefon) {
        this.kundeTelefon = kundeTelefon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
