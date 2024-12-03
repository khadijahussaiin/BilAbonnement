package com.example.bilabonnement.Model;
//Log ind side
/*Lavet af Khadija og Bushra */
public class Useradministration {
    private int UserID;
    private String Brugernavn;
    private String kode;

    public Useradministration() {
    }
    public Useradministration(int UserID, String Brugernavn, String kode) {
        this.UserID = UserID;
        this.Brugernavn = Brugernavn;
        this.kode = kode;
    }
    public int getUserID() {
        return UserID;
    }
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    public String getBrugernavn() {
        return Brugernavn;
    }
    public void setBrugernavn(String Brugernavn) {
        this.Brugernavn = Brugernavn;
    }
    public String getKode(){
        return kode;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }
}


