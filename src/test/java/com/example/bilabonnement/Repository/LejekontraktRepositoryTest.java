package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Lejekontrakt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LejekontraktRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private LejekontraktRepository lejekontraktRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchAllLejekontraktInfo() {
        // Arrange
        String sql = "SELECT " +
                "    Image.Imageurl, " +
                "    Lejekontrakt.LejekontraktID, " +
                "    Lejekontrakt.StartDato, " +
                "    Lejekontrakt.SlutDato, " +
                "    Lejekontrakt.Pris, " +
                "    Bil.Vognnummer, " +
                "    Kunde.Navn, " +
                "    Kunde.Email, " +
                "    Kunde.Telefon, " +
                "    StatusLK.StatusNavn AS Status " +
                "FROM " +
                "    Lejekontrakt " +
                "LEFT JOIN " +
                "    Bil ON Lejekontrakt.Vognnummer = Bil.Vognnummer " +
                "LEFT JOIN " +
                "    Kunde ON Lejekontrakt.KundeID = Kunde.KundeID " +
                "LEFT JOIN " +
                "    Image ON Bil.Vognnummer = Image.Vognnummer " +
                "LEFT JOIN " +
                "    StatusLK ON Lejekontrakt.StatusID = StatusLK.StatusID";

        List<Lejekontrakt> mockLejekontrakter = new ArrayList<>();
        Lejekontrakt lejekontrakt = new Lejekontrakt();
        lejekontrakt.setLejekontraktID(1);
        lejekontrakt.setStartDato("2023-01-01");
        lejekontrakt.setSlutDato("2023-02-01");
        lejekontrakt.setPris(5000.0);
        lejekontrakt.setVognnummer("AB12345");
        lejekontrakt.setNavn("John Doe");
        lejekontrakt.setEmail("john.doe@example.com");
        lejekontrakt.setTelefon("12345678");
        lejekontrakt.setStatus("Aktiv");
        lejekontrakt.setImageurl("http://example.com/image.jpg");

        mockLejekontrakter.add(lejekontrakt);

        when(jdbcTemplate.query(eq(sql), any(BeanPropertyRowMapper.class))).thenReturn(mockLejekontrakter);

        // Act
        List<Lejekontrakt> result = lejekontraktRepository.fetchAllLejekontraktInfo();

        // Assert
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getNavn());
        assertEquals("Aktiv", result.get(0).getStatus());
        verify(jdbcTemplate, times(1)).query(eq(sql), any(BeanPropertyRowMapper.class));
    }
}
