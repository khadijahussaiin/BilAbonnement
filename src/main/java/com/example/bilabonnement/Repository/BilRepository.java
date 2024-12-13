package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Bil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BilRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //1. metode til at vise alle biler fra databasen
    public List<Bil> fetchAllBiler() {
        String sql = "SELECT Bil.Vognnummer, Bil.Maerke, Bil.Stelnummer, Bil.Model, Bil.Staalpris, Bil.RegAfgift, Bil.CO2Udledning, Bil.GearType, Tilstand.TilstandNavn, Image.Imageurl " +
                "FROM Bil " +
                "LEFT JOIN Tilstand ON Bil.TilstandID = Tilstand.TilstandID " +
                "LEFT JOIN Image ON Bil.Vognnummer = Image.Vognnummer";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Bil.class));
    }
    //2. Metode til at oprette ny bil
    public int saveBil(String vognnummer, String maerke, String stelnummer, int model, Double staalpris,
                       Double regAfgift, Double co2Udledning, String gearType, int tilstandID, String imageUrl) {

        // Insert into Bil table
        String sqlBil = "INSERT INTO Bil (Vognnummer, Maerke, Stelnummer, Model, Staalpris, RegAfgift, " +
                "CO2Udledning, GearType, TilstandID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sqlBil, vognnummer, maerke, stelnummer, model, staalpris, regAfgift, co2Udledning, gearType, tilstandID);

        // Insert into Image table
        String sqlImage = "INSERT INTO Image (Vognnummer, Imageurl) VALUES (?, ?)";
        return jdbcTemplate.update(sqlImage, vognnummer, imageUrl);
    }
    //3. opdater bil
    public int updateBil(String vognnummer, String maerke, String stelnummer, int model, Double staalpris,
                         Double regAfgift, Double co2Udledning, String gearType, int tilstandID, String imageUrl) {

        // Update Bil table
        String sqlBil = "UPDATE Bil SET Maerke = ?, Stelnummer = ?, Model = ?, Staalpris = ?, " +
                "RegAfgift = ?, CO2Udledning = ?, GearType = ?, TilstandID = ? WHERE Vognnummer = ?";

        jdbcTemplate.update(sqlBil, maerke, stelnummer, model, staalpris, regAfgift, co2Udledning, gearType, tilstandID, vognnummer);

        // Update Image table
        String sqlImage = "UPDATE Image SET Imageurl = ? WHERE Vognnummer = ?";
        return jdbcTemplate.update(sqlImage, imageUrl, vognnummer);
    }
    // metode som finder oplysninger om en specifik bil baserey på bilens vognummer
    public Bil findBilByVognnummer(String vognnummer) {
        String sql = "SELECT Bil.Vognnummer, Bil.Maerke, Bil.Stelnummer, Bil.Model, Bil.Staalpris, " +
                "Bil.RegAfgift, Bil.CO2Udledning, Bil.GearType, Tilstand.TilstandNavn AS tilstand, " +
                "Image.Imageurl AS imageUrl " +
                "FROM Bil " +
                "LEFT JOIN Tilstand ON Bil.TilstandID = Tilstand.TilstandID " +
                "LEFT JOIN Image ON Bil.Vognnummer = Image.Vognnummer " +
                "WHERE Bil.Vognnummer = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Bil.class), vognnummer);
    }
    //4. metode til at slette bil
    public int deleteBil(String vognnummer) {
        // Slet fra Image-tabellen først på grund af foreign key relationen
        String sqlImage = "DELETE FROM Image WHERE Vognnummer = ?";
        jdbcTemplate.update(sqlImage, vognnummer);

        // Slet fra Bil-tabellen
        String sqlBil = "DELETE FROM Bil WHERE Vognnummer = ?";
        return jdbcTemplate.update(sqlBil, vognnummer);
    }
    // 5. Søgefunktion til biler baseret på vognnummer, mærke eller tilstand
    public List<Bil> searchBiler(String searchTerm) {
        String sql = "SELECT Bil.Vognnummer, Bil.Maerke, Bil.Stelnummer, Bil.Model, Bil.Staalpris, " +
                "Bil.RegAfgift, Bil.CO2Udledning, Bil.GearType, Tilstand.TilstandNavn AS tilstandNavn, " +
                "Image.Imageurl AS imageurl " +
                "FROM Bil " +
                "LEFT JOIN Tilstand ON Bil.TilstandID = Tilstand.TilstandID " +
                "LEFT JOIN Image ON Bil.Vognnummer = Image.Vognnummer " +
                "WHERE Bil.Vognnummer LIKE ? OR Bil.Maerke LIKE ? OR Tilstand.TilstandNavn LIKE ?";

        String likeSearchTerm = "%" + searchTerm + "%";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Bil.class), likeSearchTerm, likeSearchTerm, likeSearchTerm);
    }
}
