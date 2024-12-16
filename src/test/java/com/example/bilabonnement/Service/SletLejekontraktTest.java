package com.example.bilabonnement.Service;

import com.example.bilabonnement.Repository.LejekontraktRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class SletLejekontraktTest {

    @Mock//LejekontraktRepository er mocket med @Mock for at simulere opførslen af repositoryet.
    private LejekontraktRepository lejekontraktRepository;

    @InjectMocks //injicerer det mocket repository (lejekontraktRepository) i serviceklassen (LejekontraktService).
    private LejekontraktService lejekontraktService;

    public SletLejekontraktTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteLejekontrakt() {
        // Arrange: En variabel lejekontraktID med en testværdi (fx 123) er oprettet.
        int lejekontraktID = 123;
        // Act: Metoden deleteLejekontrakt(lejekontraktID) kaldes på serviceklassen.
        lejekontraktService.deleteLejekontrakt(lejekontraktID);
        // Assert: verificerer, at metoden deleteLejekontrakt i repositoryet blev kaldt én gang med det korrekte parameter.
        verify(lejekontraktRepository, times(1)).deleteLejekontrakt(lejekontraktID);
    }
}
