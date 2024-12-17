package com.example.bilabonnement.Repository;
//Khadija
import com.example.bilabonnement.Model.Lejekontrakt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LejekontraktRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //1. Henter alle lejekontrakter
    public List<Lejekontrakt> fetchAllLejekontraktInfo() {
        String sql = "SELECT " +
                "    Image.Imageurl, " +
                "    Lejekontrakt.LejekontraktID, " +
                "    Lejekontrakt.StartDato, " +
                "    Lejekontrakt.SlutDato, " +
                "    Lejekontrakt.Pris, " +
                "    Bil.Vognnummer, " +
                "    Kunde.Navn, " +
                "    Kunde.Email, " +
                "    Kunde.Telefon, " +
                "    StatusLK.StatusNavn AS Status " +
                "FROM " +
                "    Lejekontrakt " +
                "LEFT JOIN " +
                "    Bil ON Lejekontrakt.Vognnummer = Bil.Vognnummer " +
                "LEFT JOIN " +
                "    Kunde ON Lejekontrakt.KundeID = Kunde.KundeID " +
                "LEFT JOIN " +
                "    Image ON Bil.Vognnummer = Image.Vognnummer " +
                "LEFT JOIN " +
                "    StatusLK ON Lejekontrakt.StatusID = StatusLK.StatusID";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Lejekontrakt.class));
    }
    //2. Opretter en ny lejekontrakt
    // Metode til at gemme en ny lejekontrakt
    public void saveLejekontrakt(String startDato, String slutDato, double pris, String vognnummer,
                                 String navn, String email, String telefon, int statusID) {
        // Indsæt eller opdater kundeoplysninger
        String sqlKunde = "INSERT INTO Kunde (Navn, Email, Telefon) " +
                "VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE Email = VALUES(Email), Telefon = VALUES(Telefon)";
        jdbcTemplate.update(sqlKunde, navn, email, telefon);

        // Hent KundeID baseret på Navn
        String sqlKundeID = "SELECT KundeID FROM Kunde WHERE Navn = ? AND Email = ? AND Telefon = ?";
        int kundeID = jdbcTemplate.queryForObject(sqlKundeID, Integer.class, navn, email, telefon);

        // Indsæt lejekontrakt
        String sqlLejekontrakt = "INSERT INTO Lejekontrakt (StartDato, SlutDato, Pris, Vognnummer, KundeID, StatusID) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlLejekontrakt, startDato, slutDato, pris, vognnummer, kundeID, statusID);
    }
    //3. Metode til at opdatere en eksisterende lejekontrakt
    public void updateLejekontrakt(int lejekontraktID, String startDato, String slutDato, double pris,
                                   String vognnummer, int kundeID, String navn, String email, String telefon, int statusID) {
        // Opdater kundeoplysninger
        String sqlKunde = "UPDATE Kunde SET Navn = ?, Email = ?, Telefon = ? WHERE KundeID = ?";
        jdbcTemplate.update(sqlKunde, navn, email, telefon, kundeID);

        // Opdater lejekontraktoplysninger
        String sqlLejekontrakt = "UPDATE Lejekontrakt " +
                "SET StartDato = ?, SlutDato = ?, Pris = ?, Vognnummer = ?, StatusID = ? " +
                "WHERE LejekontraktID = ?";
        jdbcTemplate.update(sqlLejekontrakt, startDato, slutDato, pris, vognnummer, statusID, lejekontraktID);
    }

    // Metode til at hente en enkelt lejekontrakt baseret på ID
    public Lejekontrakt findLejekontraktById(int lejekontraktID) {
        String sql = "SELECT " +
                "    Image.Imageurl, Lejekontrakt.LejekontraktID, Lejekontrakt.StartDato, Lejekontrakt.SlutDato, " +
                "    Lejekontrakt.Pris, Bil.Vognnummer, Kunde.KundeID, Kunde.Navn, Kunde.Email, Kunde.Telefon, " +
                "    StatusLK.StatusNavn AS Status " +
                "FROM Lejekontrakt " +
                "LEFT JOIN Bil ON Lejekontrakt.Vognnummer = Bil.Vognnummer " +
                "LEFT JOIN Kunde ON Lejekontrakt.KundeID = Kunde.KundeID " +
                "LEFT JOIN Image ON Bil.Vognnummer = Image.Vognnummer " +
                "LEFT JOIN StatusLK ON Lejekontrakt.StatusID = StatusLK.StatusID " +
                "WHERE Lejekontrakt.LejekontraktID = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Lejekontrakt.class), lejekontraktID);
    }
    //4. slet lejekontrakt
    public void deleteLejekontrakt(int lejekontraktID) {
        String sql = "DELETE FROM Lejekontrakt WHERE LejekontraktID = ?";
        jdbcTemplate.update(sql, lejekontraktID);
    }
    //5. Metode til at søge lejekontrakter baseret på ID, vognnummer, navn eller status
    public List<Lejekontrakt> searchLejekontrakter(String soegeord) {
        String sql = "SELECT " +
                "    Image.Imageurl, Lejekontrakt.LejekontraktID, Lejekontrakt.StartDato, Lejekontrakt.SlutDato, " +
                "    Lejekontrakt.Pris, Bil.Vognnummer, Kunde.Navn, Kunde.Email, Kunde.Telefon, " +
                "    StatusLK.StatusNavn AS Status " +
                "FROM Lejekontrakt " +
                "LEFT JOIN Bil ON Lejekontrakt.Vognnummer = Bil.Vognnummer " +
                "LEFT JOIN Kunde ON Lejekontrakt.KundeID = Kunde.KundeID " +
                "LEFT JOIN Image ON Bil.Vognnummer = Image.Vognnummer " +
                "LEFT JOIN StatusLK ON Lejekontrakt.StatusID = StatusLK.StatusID " +
                "WHERE Lejekontrakt.LejekontraktID LIKE ? " +
                "   OR Bil.Vognnummer LIKE ? " +
                "   OR Kunde.Navn LIKE ? " +
                "   OR StatusLK.StatusNavn LIKE ?";

        return jdbcTemplate.query(sql, new Object[]{
                "%" + soegeord + "%", // Matcher LejekontraktID
                "%" + soegeord + "%", // Matcher Vognnummer
                "%" + soegeord + "%", // Matcher Navn
                "%" + soegeord + "%"  // Matcher Status
        }, new BeanPropertyRowMapper<>(Lejekontrakt.class));
    }
}