package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Lejekontrakt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class LejekontraktRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Lejekontrakt> fetchAllLejekontrakter() {
        String sql = "SELECT " +
                "Image.Imageurl, " +
                "Lejekontrakt.LejekontraktID, " +
                "Lejekontrakt.StartDato, " +
                "Lejekontrakt.SlutDato, " +
                "Lejekontrakt.Pris, " +
                "Lejekontrakt.Vognnummer, " +
                "Kunde.Navn AS kundeNavn, " +
                "Kunde.Email AS kundeEmail, " +
                "Kunde.Telefon AS kundeTelefon, " +
                "StatusLK.StatusNavn AS status " +
                "FROM Image " +
                "INNER JOIN Lejekontrakt ON Image.Vognnummer = Lejekontrakt.Vognnummer " +
                "INNER JOIN Kunde ON Lejekontrakt.KundeID = Kunde.KundeID " +
                "INNER JOIN StatusLK ON Lejekontrakt.StatusID = StatusLK.StatusID " +
                "ORDER BY Lejekontrakt.LejekontraktID";

        return jdbcTemplate.query(sql, new LejekontraktRowMapper());
    }

    // RowMapper implementation
    private static class LejekontraktRowMapper implements RowMapper<Lejekontrakt> {
        @Override
        public Lejekontrakt mapRow(ResultSet rs, int rowNum) throws SQLException {
            Lejekontrakt lejekontrakt = new Lejekontrakt();
            lejekontrakt.setLejekontraktID(rs.getInt("LejekontraktID"));
            lejekontrakt.setImageurl(rs.getString("Imageurl"));
            lejekontrakt.setStartDato(rs.getDate("StartDato").toLocalDate()); // Conversion to LocalDate
            lejekontrakt.setSlutDato(rs.getDate("SlutDato").toLocalDate());   // Conversion to LocalDate
            lejekontrakt.setPris(rs.getDouble("Pris"));
            lejekontrakt.setVognnummer(rs.getString("Vognnummer"));
            lejekontrakt.setKundeNavn(rs.getString("kundeNavn"));
            lejekontrakt.setKundeEmail(rs.getString("kundeEmail"));
            lejekontrakt.setKundeTelefon(rs.getString("kundeTelefon"));
            lejekontrakt.setStatus(rs.getString("status"));
            return lejekontrakt;
        }
    }
}

