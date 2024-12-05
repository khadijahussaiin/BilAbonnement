package com.example.bilabonnement.Repository;

import com.example.bilabonnement.DTOs.LejekontraktDTO;
import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Model.Kunde;
import com.example.bilabonnement.Model.Lejekontrakt;
import com.example.bilabonnement.Model.StatusLK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class LejekontraktRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //Liste over alle lejekontrakterne hvor billede af bilen  og kunde info er inkluderet
    public List<LejekontraktDTO> findAllLejekontrakter() {
        String sql = "SELECT * FROM Lejekontrakt l " +
                "JOIN Kunde k ON l.Navn = k.Navn " +
                "JOIN Bil b ON l.Vognummer = b.Vognummer";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new LejekontraktDTO(
                        new Lejekontrakt(rs.getInt("LejekontraktID"), rs.getString("Navn"), rs.getString("Vognummer"), rs.getDate("StartDato").toLocalDate(),
                                rs.getDate("SlutDate").toLocalDate(), rs.getDouble("pris"), StatusLK.valueOf(rs.getString("StatusLK"))),
                        new Kunde(rs.getString("Navn"), rs.getString("Email"), rs.getString("Telefon")),
                        new Bil(rs.getString("billede")
                        )
                )
        );

    }
}

