package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Bil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BilRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // ok så det her henter alle biller
    public List<Bil> fetchAllBiler() {
        String sql = "SELECT " +
                "Bil.Vognnummer, Bil.Stelnummer, Bil.Model, Bil.Staalpris, Bil.RegAfgift, " +
                "Bil.CO2Udledning, Bil.GearType, Bil.Maerke, Tilstand.TilstandNavn AS tilstand, " +
                "Image.Imageurl " +
                "FROM Bil " +
                "LEFT JOIN Tilstand ON Bil.TilstandID = Tilstand.TilstandID " +
                "LEFT JOIN Image ON Bil.Vognnummer = Image.Vognnummer";

        return jdbcTemplate.query(sql, new BilRowMapper());
    }

    //  det her gær det muligt at søge efter en bil med sin nummerplade
    // tilhøre også controlleren
    public List<Bil> searchByVognnummer(String vognnummer) {
        String sql = "SELECT " +
                "Bil.Vognnummer, Bil.Stelnummer, Bil.Model, Bil.Staalpris, Bil.RegAfgift, " +
                "Bil.CO2Udledning, Bil.GearType, Bil.Maerke, Tilstand.TilstandNavn AS tilstand, " +
                "Image.Imageurl " +
                "FROM Bil " +
                "LEFT JOIN Tilstand ON Bil.TilstandID = Tilstand.TilstandID " +
                "LEFT JOIN Image ON Bil.Vognnummer = Image.Vognnummer " +
                "WHERE Bil.Vognnummer LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + vognnummer + "%"}, new BilRowMapper());
    }

    //  Det her opretter en ny bil i databasen
    public void addBil(Bil bil) {
        String sql = "INSERT INTO Bil (Vognnummer, Maerke, Stelnummer, Model, Staalpris, RegAfgift, CO2Udledning, GearType, TilstandID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, bil.getVognnummer(), bil.getMaerke(), bil.getStelnummer(),
                bil.getModel(), bil.getStaalpris(), bil.getRegAfgift(),
                bil.getCo2Udledning(), bil.getGearType(), bil.getTilstandID());
    }

    // Mapper resultater fra databasen til Bil-objekter
    private static class BilRowMapper implements RowMapper<Bil> {
        @Override
        public Bil mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bil bil = new Bil();
            bil.setVognnummer(rs.getString("Vognnummer"));
            bil.setStelnummer(rs.getString("Stelnummer"));
            bil.setModel(rs.getInt("Model"));
            bil.setStaalpris(rs.getDouble("Staalpris"));
            bil.setRegAfgift(rs.getDouble("RegAfgift"));
            bil.setCo2Udledning(rs.getDouble("CO2Udledning"));
            bil.setGearType(rs.getString("GearType"));
            bil.setMaerke(rs.getString("Maerke"));
            bil.setTilstand(rs.getString("tilstand"));
            bil.setBillede(rs.getString("Imageurl"));
            return bil;
        }
    }
}
