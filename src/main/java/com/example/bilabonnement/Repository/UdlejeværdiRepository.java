package com.example.bilabonnement.Repository;
//Søren
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
// Søren
@Repository
public class UdlejeværdiRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Map<String, Object>
    public Map<String, Object> totalSum() {
        String sql =  "SELECT COUNT(*) AS antalAktive, " +
                      "SUM(pris) AS sumAfPriser " +
                      "FROM lejekontrakt " +
                      "WHERE statusID = 1";
        return jdbcTemplate.queryForMap(sql);
    }
}
