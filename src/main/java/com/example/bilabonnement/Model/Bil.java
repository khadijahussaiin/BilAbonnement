package com.example.bilabonnement.Model;

public class Bil {
    private String Vognnummer;
    private String Stelnummer;
    private int Model;
    private double Staalpris;
    private double RegAfgift;
    private double CO2Udledning;
    private String GearType;
    private byte[] Billede; //Ændret Longblob til byte array. alm. byte kan ikke bruges hvis den skal samarbejde med databasen og thymeleaf
    private Tilstand Tilstand;
}

