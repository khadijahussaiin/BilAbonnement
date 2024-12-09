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
    //1. vis alle biler controller
    @GetMapping("/BilAdministration")
    public String getBiler(Model model) {
        List<Bil> biler = bilService.findAll();
        model.addAttribute("biler", biler);
        return "home/BilAdministration"; // Navnet på Thymeleaf-skabelonen (biler.html)
    }
    //2 opret biler
    @GetMapping("/opretBil")
    public String visOpretBil(Model model) {
        return "home/opretBil"; // Thymeleaf-filnavn
    }
    @PostMapping("/opretBil")
    public String gemBil(@RequestParam String vognnummer,
                         @RequestParam String maerke,
                         @RequestParam String stelnummer,
                         @RequestParam int model,
                         @RequestParam Double staalpris,
                         @RequestParam Double regAfgift,
                         @RequestParam Double co2Udledning,
                         @RequestParam String gearType,
                         @RequestParam int tilstandID,
                         @RequestParam String imageUrl) {
        bilService.createBil(vognnummer, maerke, stelnummer, model, staalpris, regAfgift, co2Udledning, gearType, tilstandID, imageUrl);
        return "redirect:/BilAdministration"; // Efter oprettelse vises alle biler
    }
    //3. opdater biler
    @GetMapping("/opdaterBil/{vognnummer}")
    public String visOpdaterBil(@PathVariable String vognnummer, Model model) {
        Bil bil = bilService.getBilByVognnummer(vognnummer);
        model.addAttribute("bil", bil);
        return "home/opdaterBil"; // Thymeleaf-filnavn
    }
    @PostMapping("/opdaterBil")
    public String gemOpdatering(@RequestParam String vognnummer,
                                @RequestParam String maerke,
                                @RequestParam String stelnummer,
                                @RequestParam int model,
                                @RequestParam Double staalpris,
                                @RequestParam Double regAfgift,
                                @RequestParam Double co2Udledning,
                                @RequestParam String gearType,
                                @RequestParam int tilstandID,
                                @RequestParam String imageUrl) {
        bilService.updateBil(vognnummer, maerke, stelnummer, model, staalpris, regAfgift, co2Udledning, gearType, tilstandID, imageUrl);
        return "redirect:/BilAdministration"; // Efter opdatering vises alle biler
    }
    // 4. Controller-metode til at slette en bil
    @GetMapping("/sletBil/{vognnummer}")
    public String sletBil(@PathVariable String vognnummer) {
        bilService.deleteBil(vognnummer);
        return "redirect:/BilAdministration"; // Gå tilbage til oversigten efter sletning
    }
    // 5. Controller-metode til at søge efter biler
    @GetMapping("/searchBil")
    public String searchBil(@RequestParam(required = false) String searchTerm, Model model) {
        List<Bil> biler;
        if (searchTerm != null && !searchTerm.isEmpty()) {
            biler = bilService.searchBiler(searchTerm);
        } else {
            biler = bilService.findAll(); // Hvis ingen søgeterm, vis alle biler
        }
        model.addAttribute("biler", biler);
        model.addAttribute("searchTerm", searchTerm); // Bevar søgeterm i inputfeltet
        return "home/BilAdministration"; // Viser resultaterne på samme side som biladministration
    }
}




