package com.example.bilabonnement.Service;

import com.example.bilabonnement.Repository.SkaderapportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class SaveSkaderapportTest {

    @Mock// Mock SkaderapportRepository for at simulere repository-metoder.
    private SkaderapportRepository skaderapportRepository;

    @InjectMocks//@InjectMocks: Injicer det mockede repository i SkaderapportService.
    private SkaderapportService skaderapportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialiserer mock-objekterne
    }

    @Test
    void testSaveSkaderapport() {
        // Arrange: Definér de inputparametre, der skal bruges i testen.
        String vognnummer = "AB123";
        String dato = "2023-12-10";
        double overkoerteKilometer = 10000.0;
        String checkAfSkade = "FDM";
        String skadeBeskrivelse = "Ridse på venstre dør";
        double prisIAlt = 3000.0;

        // Act: Kald createSkaderapport-metoden fra service-klassen med testdataene.
        skaderapportService.createSkaderapport(
                vognnummer, dato, overkoerteKilometer, checkAfSkade, skadeBeskrivelse, prisIAlt
        );

        // Assert: Brug verify fra Mockito til at sikre, at saveSkaderapport i SkaderapportRepository blev kaldt én gang med de rigtige parametre
        verify(skaderapportRepository, times(1)).saveSkaderapport(
                eq(vognnummer), eq(dato), eq(overkoerteKilometer), eq(checkAfSkade), eq(skadeBeskrivelse), eq(prisIAlt)
        );
    }
}