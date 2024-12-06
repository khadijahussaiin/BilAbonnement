package com.example.bilabonnement.Controller;


import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Service.BilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class BilController {


    @Autowired
    private BilService bilService;


    // Hent alle biler til visning på administrationssiden
    @GetMapping("/BilAdministration")
    public String getBiler(Model model) {
        List<Bil> biler = bilService.getAllBiler();
        model.addAttribute("biler", biler); // Tilføjer listen af biler til modellen
        return "home/BilAdministration";
    }

    @GetMapping("/search")
    public String searchBil(@RequestParam("vognnummer") String vognnummer, Model model) {
        List<Bil> biler = bilService.searchByVognnummer(vognnummer);
        model.addAttribute("biler", biler); // Viser bilerne der er blevet fundet
        return "home/BilAdministration";
    }

    @GetMapping("/OpretBil")
    public String showAddBilForm() {
        return "home/OperetBil";
    }

    // Håndter oprettelse af en ny bil
    @PostMapping("/OpretBil")
    public String addBil(@ModelAttribute Bil bil) {
        bilService.addBil(bil); // Gemmer bilen i databasen
        return "redirect:/BilAdministration"; // Redirecter til biladministrationssiden
    }
}

