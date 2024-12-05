package com.example.bilabonnement.Model;

public class Bil {
    private String vognnummer;
    private String stelnummer;
    private int model;
    private double staalpris;
    private double regAfgift;
    private double co2Udledning;
    private String gearType;
    private String billede;
    private String tilstand;

    // Parameterløs konstruktør
    public Bil() {
    }

    public Bil(String vognnummer, String stelnummer, int model, double staalpris, double regAfgift, double co2Udledning, String gearType, String billede, String tilstand) {
        this.vognnummer = vognnummer;
        this.stelnummer = stelnummer;
        this.model = model;
        this.staalpris = staalpris;
        this.regAfgift = regAfgift;
        this.co2Udledning = co2Udledning;
        this.gearType = gearType;
        this.billede = billede;
        this.tilstand = tilstand;
    }

    public Bil(String billede) {
        this.billede = billede;
    }

    // Getters and Setters
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

    public String getBillede() {
        return billede;
    }

    public void setBillede(String billede) {
        this.billede = billede;
    }

    public String getTilstand() {
        return tilstand;
    }

    public void setTilstand(String tilstand) {
        this.tilstand = tilstand;

    }
}