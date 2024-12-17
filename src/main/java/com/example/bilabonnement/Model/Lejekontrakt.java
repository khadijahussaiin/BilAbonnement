package com.example.bilabonnement.Model;
//Khadija
public class Lejekontrakt {
    private String imageurl;
    private int lejekontraktID;
    private String startDato;
    private String slutDato;
    private double pris;
    private String vognnummer;
    private int kundeID;
    private String navn;
    private String email;
    private String telefon;
    private String status;

    public Lejekontrakt() {
    }
    public Lejekontrakt(String imageurl, int lejekontraktID, String startDato, String slutDato, double pris, String vognnummer, int kundeID, String navn, String email, String telefon, String status) {
        this.imageurl = imageurl;
        this.lejekontraktID = lejekontraktID;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.pris = pris;
        this.vognnummer = vognnummer;
        this.kundeID = kundeID;
        this.navn = navn;
        this.email = email;
        this.telefon = telefon;
        this.status = status;
    }
    // Getters og Setters
    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getLejekontraktID() {
        return lejekontraktID;
    }

    public void setLejekontraktID(int lejekontraktID) {
        this.lejekontraktID = lejekontraktID;
    }

    public String getStartDato() {
        return startDato;
    }

    public void setStartDato(String startDato) {
        this.startDato = startDato;
    }

    public String getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(String slutDato) {
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
    public int getKundeID() { //
        return kundeID;
    }

    public void setKundeID(int kundeID) { //
        this.kundeID = kundeID;
    }
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
