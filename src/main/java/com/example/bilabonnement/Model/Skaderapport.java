package com.example.bilabonnement.Model;

public class Skaderapport {
    private int skadeID;
    private String vognnummer;
    private String dato;
    private double overkoerteKilometer;
    private String checkAfSkade;
    private String skadeBeskrivelse;
    private double prisIAlt;

    public Skaderapport() {
    }
    public Skaderapport(int skadeID, String vognnummer, String dato, double overkoerteKilometer, String checkAfSkade, String skadeBeskrivelse, double prisIAlt) {
    }

    // Getters og setters
    public int getSkadeID() {
        return skadeID;
    }

    public void setSkadeID(int skadeID) {
        this.skadeID = skadeID;
    }

    public String getVognnummer() {
        return vognnummer;
    }

    public void setVognnummer(String vognnummer) {
        this.vognnummer = vognnummer;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public double getOverkoerteKilometer() {
        return overkoerteKilometer;
    }

    public void setOverkoerteKilometer(double overkoerteKilometer) {
        this.overkoerteKilometer = overkoerteKilometer;
    }

    public String getCheckAfSkade() {
        return checkAfSkade;
    }

    public void setCheckAfSkade(String checkAfSkade) {
        this.checkAfSkade = checkAfSkade;
    }

    public String getSkadeBeskrivelse() {
        return skadeBeskrivelse;
    }

    public void setSkadeBeskrivelse(String skadeBeskrivelse) {
        this.skadeBeskrivelse = skadeBeskrivelse;
    }

    public double getPrisIAlt() {
        return prisIAlt;
    }

    public void setPrisIAlt(double prisIAlt) {
        this.prisIAlt = prisIAlt;
    }
}
