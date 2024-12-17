package com.example.bilabonnement.Repository;
//Søren og Khadija
import com.example.bilabonnement.Model.Skaderapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkaderapportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 1. Metode til at hente alle skaderapporter
    public List<Skaderapport> fetchAll() {
        String sql = "SELECT SkadeID, Vognnummer, Dato, OverkoerteKilometer, CheckAfSkade, SkadeBeskrivelse, PrisIAlt FROM Skaderapport";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Skaderapport.class));
    }
    // 2. Metode til at oprette en ny skaderapport
    public int saveSkaderapport(String vognnummer, String dato, double overkoerteKilometer, String checkAfSkade, String skadeBeskrivelse, double prisIAlt) {
        String sql = "INSERT INTO Skaderapport (Vognnummer, Dato, OverkoerteKilometer, CheckAfSkade, SkadeBeskrivelse, PrisIAlt) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, vognnummer, dato, overkoerteKilometer, checkAfSkade, skadeBeskrivelse, prisIAlt);
    }
    //3.Metode til at opdatere en eksisterende skaderapport
    public int updateSkaderapport(int skadeID, String vognnummer, String dato, double overkoerteKilometer, String checkAfSkade, String skadeBeskrivelse, double prisIAlt) {
        String sql = "UPDATE Skaderapport SET " +
                "Vognnummer = ?, Dato = ?, OverkoerteKilometer = ?, CheckAfSkade = ?, SkadeBeskrivelse = ?, PrisIAlt = ? " +
                "WHERE SkadeID = ?";
        return jdbcTemplate.update(sql, vognnummer, dato, overkoerteKilometer, checkAfSkade, skadeBeskrivelse, prisIAlt, skadeID);
    }
    // Metode til at hente en specifik skaderapport baseret på ID
    public Skaderapport findById(int skadeID) {
        String sql = "SELECT SkadeID, Vognnummer, Dato, OverkoerteKilometer, CheckAfSkade, SkadeBeskrivelse, PrisIAlt FROM Skaderapport WHERE SkadeID = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Skaderapport.class), skadeID);
    }
    //4.// Metode til at slette en skaderapport baseret på SkadeID
    public int deleteById(int skadeID) {
        String sql = "DELETE FROM Skaderapport WHERE SkadeID = ?";
        return jdbcTemplate.update(sql, skadeID);
    }
    //5.Metode til at søge efter skaderapporter baseret på ID eller vognnummer og cehck af skade
    public List<Skaderapport> searchByIdOrVognnummerOrCheckAfSkade(String searchTerm) {
        String sql = "SELECT SkadeID, Vognnummer, Dato, OverkoerteKilometer, CheckAfSkade, SkadeBeskrivelse, PrisIAlt " +
                "FROM Skaderapport " +
                "WHERE CAST(SkadeID AS CHAR) = ? " +
                "   OR Vognnummer LIKE ? " +
                "   OR CheckAfSkade LIKE ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Skaderapport.class),
                searchTerm, "%" + searchTerm + "%", "%" + searchTerm + "%");
    }
}


