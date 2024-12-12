package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.UseradministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class LogIndController {

    @Autowired
    private UseradministrationService useradministrationService;

    @GetMapping("/")
    public String showLogIndPage() {
        return "home/LogInd"; // Dette matcher logind.html i templates/home/
    }

    @GetMapping("/dashboard")
    public String showLogDashboard(Model model) {
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("currentDate", currentDate);

        return "home/Dashboard"; // Dette matcher Dashboard i templates/home/
    }
    @PostMapping("/LogInd")
    public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        boolean isValidUser = useradministrationService.validateUser(username, password);

        if (isValidUser) {
            return "redirect:/dashboard"; // Omdiriger til dashboard, hvis login lykkes
        } else {
            model.addAttribute("error", "Ugyldigt brugernavn eller adgangskode.");
            return "home/LogInd"; // hvis log ind ikke lykkes forbliver man på log ind side og fejlmeddelse dukker op
        }
    }
}

