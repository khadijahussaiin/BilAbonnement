package com.example.bilabonnement.Model;
//Bushra og Khadija
public class Bil {
    private String vognnummer;
    private String maerke;
    private String stelnummer;
    private int model;
    private double staalpris;
    private double regAfgift;
    private double co2Udledning;
    private String gearType;
    private String tilstandNavn;
    private String imageurl;

    public Bil(){
    }
    public Bil(String vognnummer, String maerke, String stelnummer, int model, double staalpris, double regAfgift, double co2Udledning, String gearType, String tilstandNavn, String imageurl) {
        this.vognnummer = vognnummer;
        this.maerke = maerke;
        this.stelnummer = stelnummer;
        this.model = model;
        this.staalpris = staalpris;
        this.regAfgift = regAfgift;
        this.co2Udledning = co2Udledning;
        this.gearType = gearType;
        this.tilstandNavn = tilstandNavn;
        this.imageurl = imageurl;
    }

    // Getters og setters
    public String getVognnummer() {
        return vognnummer;
    }

    public void setVognnummer(String vognnummer) {
        this.vognnummer = vognnummer;
    }

    public String getMaerke() {
        return maerke;
    }

    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    public String getStelnummer() {
        return stelnummer;
    }

    public void setStelnummer(String stelnummer) {
        this.stelnummer = stelnummer;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public double getStaalpris() {
        return staalpris;
    }

    public void setStaalpris(double staalpris) {
        this.staalpris = staalpris;
    }

    public double getRegAfgift() {
        return regAfgift;
    }

    public void setRegAfgift(double regAfgift) {
        this.regAfgift = regAfgift;
    }

    public double getCo2Udledning() {
        return co2Udledning;
    }

    public void setCo2Udledning(double co2Udledning) {
        this.co2Udledning = co2Udledning;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getTilstandNavn() {
        return tilstandNavn;
    }

    public void setTilstandNavn(String tilstandNavn) {
        this.tilstandNavn = tilstandNavn;
    }
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
