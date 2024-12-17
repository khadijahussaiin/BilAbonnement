package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.UseradministrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LogIndControllerTest {

    @Mock //En falsk version af UseradministrationService
    private UseradministrationService useradministrationService;

    @Mock
    private Model model;

    @InjectMocks//Put de falske objekter ind i din klasse (dependency injection).
    private LogIndController logIndController;

    @BeforeEach//Initialiser mocks før hver test for at sikre, at de er klar.
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowLogIndPage() {
        // Act
        String viewName = logIndController.showLogIndPage();
        // Assert
        assertEquals("home/LogInd.html", viewName, "Should return the correct view name for login page.");
    }

    @Test
    void testShowLogDashboard() {
        // Arrange
        LocalDate currentDate = LocalDate.now();
        // Act
        String viewName = logIndController.showLogDashboard(model);
        // Assert
        assertEquals("home/Dashboard", viewName, "Should return the correct view name for dashboard.");
        verify(model, times(1)).addAttribute("currentDate", currentDate);
    }

    @Test
    void testProcessLogin_ValidUser() {
        // Arrange
        String username = "validUser";
        String password = "validPassword";
        when(useradministrationService.validateUser(username, password)).thenReturn(true);

        // Act
        String result = logIndController.processLogin(username, password, model);

        // Assert
        assertEquals("redirect:/dashboard", result, "Should redirect to dashboard for valid user.");
        verify(useradministrationService, times(1)).validateUser(username, password);
        verifyNoInteractions(model); // Model should not be updated for successful login
    }

    @Test
    void testProcessLogin_InvalidUser() {
        // Arrange
        String username = "invalidUser";
        String password = "invalidPassword";
        when(useradministrationService.validateUser(username, password)).thenReturn(false);
        // Act
        String result = logIndController.processLogin(username, password, model);
        // Assert
        assertEquals("home/LogInd", result, "Should return to login page for invalid user.");
        verify(useradministrationService, times(1)).validateUser(username, password);
        verify(model, times(1)).addAttribute("error", "Ugyldigt brugernavn eller adgangskode.");
    }
}
