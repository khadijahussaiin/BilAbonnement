package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.Skaderapport;
import com.example.bilabonnement.Service.SkaderapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SkaderapportController {

    @Autowired
    private SkaderapportService skaderapportService;

    // 1. Controller-metode til at vise alle skaderapporter
    @GetMapping("/SkaderapportAdministration")
    public String getSkaderapporter(Model model) {
        List<Skaderapport> skaderapporter = skaderapportService.findAll();
        model.addAttribute("skaderapporter", skaderapporter);
        return "home/SkaderapportAdministration"; // HTML-filen, der viser skaderapporter
    }

    @GetMapping("/skaderapportDetaljer/{id}")
    public String visSkaderapportDetaljer(@PathVariable int id, Model model) {
        Skaderapport skaderapport = skaderapportService.getSkaderapportById(id);
        model.addAttribute("skaderapport", skaderapport);
        return "home/skaderapportDetaljer";
    }

    // 2. Vis formular til oprettelse af ny skaderapport
    @GetMapping("/opretSkaderapport")
    public String visOpretSkaderapport() {
        return "OpretSkaderapport"; // HTML-fil til oprettelse af skaderapport
    }

    // Gem en ny skaderapport
    @PostMapping("/opretSkaderapport")
    public String gemSkaderapport(@RequestParam String vognnummer,
                                  @RequestParam String dato,
                                  @RequestParam double overkoerteKilometer,
                                  @RequestParam String checkAfSkade,
                                  @RequestParam String skadeBeskrivelse,
                                  @RequestParam double prisIAlt) {
        skaderapportService.createSkaderapport(vognnummer, dato, overkoerteKilometer, checkAfSkade, skadeBeskrivelse, prisIAlt);
        return "redirect:/SkaderapportAdministration"; // Gå tilbage til visning af alle skaderapporter
    }
    //3. Vis formular til opdatering af eksisterende skaderapport
    @GetMapping("/opdaterSkaderapport/{skadeID}")
    public String visOpdaterSkaderapport(@PathVariable int skadeID, Model model) {
        Skaderapport skaderapport = skaderapportService.getSkaderapportById(skadeID);
        model.addAttribute("skaderapport", skaderapport);
        return "home/opdaterSkaderapport"; // HTML-fil til opdatering af skaderapport
    }

    // Gem opdateret skaderapport
    @PostMapping("/opdaterSkaderapport")
    public String gemOpdateretSkaderapport(@RequestParam int skadeID,
                                           @RequestParam String vognnummer,
                                           @RequestParam String dato,
                                           @RequestParam double overkoerteKilometer,
                                           @RequestParam String checkAfSkade,
                                           @RequestParam String skadeBeskrivelse,
                                           @RequestParam double prisIAlt) {
        skaderapportService.updateSkaderapport(skadeID, vognnummer, dato, overkoerteKilometer, checkAfSkade, skadeBeskrivelse, prisIAlt);
        return "redirect:/SkaderapportAdministration"; // Gå tilbage til visning af alle skaderapporter
    }
    //4.Controller-metode til at slette en skaderapport
    @GetMapping("/sletSkaderapport/{skadeID}")
    public String sletSkaderapport(@PathVariable int skadeID) {
        skaderapportService.deleteSkaderapport(skadeID);
        return "redirect:/SkaderapportAdministration"; // Gå tilbage til visning af alle skaderapporter
    }
    //5. Controller-metode til at søge efter skaderapporter
    @GetMapping("/SøgSkaderapport")
    public String søgSkaderapport(@RequestParam(required = false) String searchTerm, Model model) {
        List<Skaderapport> skaderapporter;
        if (searchTerm == null || searchTerm.isEmpty()) {
            skaderapporter = skaderapportService.findAll(); // Henter alle skaderapporter, hvis der ikke er søgeord
        } else {
            skaderapporter = skaderapportService.searchSkaderapport(searchTerm);
        }
        model.addAttribute("skaderapporter", skaderapporter);
        model.addAttribute("searchTerm", searchTerm);
        return "home/SkaderapportAdministration";
    }
}