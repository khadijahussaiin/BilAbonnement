package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Repository.BilRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SeBilTest {

    @Mock
    private BilRepository bilRepository;

    @InjectMocks
    private BilService bilService;

    public SeBilTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        Bil bil1 = new Bil("AB12345", "Toyota", "ST12345", 2021, 250000.0, 30000.0, 120.0, "Automatisk", "Lejeklar", "https://example.com/image1.jpg");
        Bil bil2 = new Bil("CD67890", "Volkswagen", "ST67890", 2020, 200000.0, 25000.0, 150.0, "Manuel", "Udlejet", "https://example.com/image2.jpg");
        List<Bil> expectedBiler = Arrays.asList(bil1, bil2);

        when(bilRepository.fetchAllBiler()).thenReturn(expectedBiler);

        // Act
        List<Bil> actualBiler = bilService.findAll();

        // Assert
        assertEquals(expectedBiler, actualBiler, "The returned list of biler should match the expected list");
        verify(bilRepository, times(1)).fetchAllBiler();
    }
}

