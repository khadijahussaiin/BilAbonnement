package com.example.bilabonnement.Model;

public class Kunde {
    private String navn;
    private String email;
    private String telefon;

    public Kunde() {
    }
    public Kunde(String navn, String email, String telefon) {
        this.navn = navn;
        this.email = email;
        this.telefon = telefon;
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
}
