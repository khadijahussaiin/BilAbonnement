package com.example.bilabonnement.Model;

public class Kunde {
    private String Navn;
    private String Email;
    private String Telefon;

    public Kunde() {
    }
    public Kunde(String navn, String email, String telefon) {
        this.Navn = navn;
        this.Email = email;
        this.Telefon = telefon;
    }
    public String getNavn() {
        return Navn;
    }
    public void setNavn(String Navn) {
        this.Navn = Navn;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getTelefon() {
        return Telefon;
    }
    public void setTelefon(String Telefon) {
        this.Telefon = Telefon;
    }
}
