package com.example.bilabonnement.Model;

public class Bil {

    private String vognnummer;
    private String stelnummer;
    private int model;
    private double staalpris;
    private double regAfgift;
    private double co2Udledning;
    private String gearType;
    private String maerke;
    private String tilstand; // Tilstanden på bilen  og det er  "Lejeklar", "Udlejet", "Skadet
    private int tilstandID; // jeg har sat bil TilstandId i  bil model klassen
    private String billede; // URL til billede af bilen


    public String getVognnummer() {
        return vognnummer;
    }

    public void setVognnummer(String vognnummer) {
        this.vognnummer = vognnummer;
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

    public String getMaerke() {
        return maerke;
    }

    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    public String getTilstand() {
        return tilstand;
    }

    public void setTilstand(String tilstand) {
        this.tilstand = tilstand;
    }

    public int getTilstandID() {
        return tilstandID;
    }

    public void setTilstandID(int tilstandID) {
        this.tilstandID = tilstandID;
    }

    public String getBillede() {
        return billede;
    }

    public void setBillede(String billede) {
        this.billede = billede;
    }
}
