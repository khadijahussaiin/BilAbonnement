package com.example.bilabonnement.Repository;
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

    public List<Lejekontrakt> findAllLejekontrakter() {
        String sql = "SELECT Bil.Billede, Lejekontrakt.LejekontraktID, Lejekontrakt.StartDato, " +
                "Lejekontrakt.SlutDato, Lejekontrakt.Pris, Lejekontrakt.Vognnummer, " +
                "Kunde.Navn, Kunde.Email, Kunde.Telefon, Lejekontrakt.StatusLK " +
                "FROM Lejekontrakt " +
                "JOIN Bil ON Lejekontrakt.Vognnummer = Bil.Vognnummer " +
                "JOIN Kunde ON Lejekontrakt.Navn = Kunde.Navn " +
                "ORDER BY Bil.Billede";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Lejekontrakt.class));
    }
}
