package com.example.bilabonnement.Repository;
import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Model.Kunde;
import com.example.bilabonnement.Model.Lejekontrakt;
import com.example.bilabonnement.Model.StatusLK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LejekontraktRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Lejekontrakt> findAllLejekontrakter() {
        String sql = "SELECT Bil.Billede, Lejekontrakt.LejekontraktID, Lejekontrakt.StartDato, " +
                "Lejekontrakt.SlutDato, Lejekontrakt.Pris, Lejekontrakt.Vognnummer,Kunde.Navn, " +
                "Kunde.Email, Kunde.Telefon, Lejekontrakt.StatusLK FROM \n" +
                "    Lejekontrakt\n" +
                "JOIN \n" +
                "    Bil ON Lejekontrakt.Vognnummer = Bil.Vognnummer\n" +
                "JOIN \n" +
                "    Kunde ON Lejekontrakt.Navn = Kunde.Navn\n" +
                "ORDER BY \n" +
                "    Bil.Billede;";

        return jdbcTemplate.query(sql, (resultSet, i) -> mapRowToLejekontrakt(resultSet));
    }

    private Lejekontrakt mapRowToLejekontrakt(ResultSet rs) throws SQLException {
        // Kunde-informationer
        Kunde kunde = new Kunde();
        kunde.setNavn(rs.getString("Navn"));
        kunde.setEmail(rs.getString("Email"));
        kunde.setTelefon(rs.getString("Telefon"));

        // Bil-informationer (kun billede)
        Bil bil = new Bil();
        bil.setBillede(rs.getString("Billede"));  // Kun billede bliver hentet

        // Lejekontrakt-informationer
        Lejekontrakt lejekontrakt = new Lejekontrakt();
        lejekontrakt.setLejekontraktID(rs.getInt("LejekontraktID"));
        lejekontrakt.setNavn(rs.getString("Navn"));
        lejekontrakt.setVognnummer(rs.getString("Vognummer"));
        lejekontrakt.setStartDato(rs.getDate("StartDato").toLocalDate());
        lejekontrakt.setSlutDato(rs.getDate("SlutDato").toLocalDate());
        lejekontrakt.setPris(rs.getDouble("Pris"));
        // Konvertering af status fra String til StatusLK enum
        String statusStr = rs.getString("StatusLK");
        lejekontrakt.setStatusLK(StatusLK.valueOf(statusStr.toUpperCase()));

        return lejekontrakt;
    }
}
