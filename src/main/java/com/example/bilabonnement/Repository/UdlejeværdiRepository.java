package com.example.bilabonnement.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UdlejeværdiRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> totalSum() {
        String sql =  "SELECT COUNT(*) AS antalAktive, " +
                      "SUM(pris) AS sumAfPriser " +
                      "FROM lejekontrakt " +
                      "WHERE statusID = 1";
        return jdbcTemplate.queryForMap(sql);
    }
}
