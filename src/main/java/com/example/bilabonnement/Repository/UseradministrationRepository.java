package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Useradministration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UseradministrationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Useradministration findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM Useradministration WHERE Brugernavn = ? AND Kode = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{username, password}, new RowMapper<Useradministration>() {
            @Override
            public Useradministration mapRow(ResultSet rs, int rowNum) throws SQLException {
                Useradministration user = new Useradministration();
                user.setUserID(rs.getInt("UserID"));
                user.setBrugernavn(rs.getString("Brugernavn"));
                user.setKode(rs.getString("Kode"));
                return user;
            }
        });
    }
}

