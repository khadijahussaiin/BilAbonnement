package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.Lejekontrakt;
import com.example.bilabonnement.Service.LejekontraktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LejekontraktController {

    @Autowired
    private LejekontraktService lejekontraktService;

    @GetMapping("/LejekontraktAdministration")
    public String showLejekontrakt(Model model) {
        List<Lejekontrakt> lejekontrakter = lejekontraktService.getAllLejekontraktInfo();
        model.addAttribute("lejekontrakter", lejekontrakter);
        return "home/LejekontraktAdministration"; // Thymeleaf-side
    }
    //2 opret biler Controller
    // Vis formularen for at oprette en ny lejekontrakt
    @GetMapping("/OpretLejekontrakt")
    public String visOpretLejekontrakt() {
        return "home/OpretLejekontrakt";
    }
    // Håndter formularindsendelse for at oprette en ny lejekontrakt
    @PostMapping("/OpretLejekontrakt")
    public String gemNyLejekontrakt(@RequestParam String startDato,
                                    @RequestParam String slutDato,
                                    @RequestParam double pris,
                                    @RequestParam String vognnummer,
                                    @RequestParam String navn,
                                    @RequestParam String email,
                                    @RequestParam String telefon,
                                    @RequestParam int statusID) {
        lejekontraktService.createLejekontrakt(startDato, slutDato, pris, vognnummer, navn, email, telefon, statusID);
        return "redirect:/LejekontraktAdministration"; // Tilbage til administrationen
    }
    //3. opdater lejekontrakt controller Vis opdateringsformularen
    // Vis opdateringsformularen
    @GetMapping("/opdaterLejekontrakt/{lejekontraktID}")
    public String visOpdaterLejekontraktForm(@PathVariable int lejekontraktID, Model model) {
        Lejekontrakt lejekontrakt = lejekontraktService.findLejekontraktById(lejekontraktID);
        model.addAttribute("lejekontrakt", lejekontrakt);
        return "home/opdaterLejekontrakt"; // Thymeleaf-side
    }
    // Håndter opdatering af lejekontrakt
    @PostMapping("/opdaterLejekontrakt")
    public String gemOpdateretLejekontrakt(@RequestParam int lejekontraktID,
                                           @RequestParam String startDato,
                                           @RequestParam String slutDato,
                                           @RequestParam double pris,
                                           @RequestParam String vognnummer,
                                           @RequestParam int kundeID,
                                           @RequestParam String navn,
                                           @RequestParam String email,
                                           @RequestParam String telefon,
                                           @RequestParam int statusID) {
        lejekontraktService.updateLejekontrakt(lejekontraktID, startDato, slutDato, pris, vognnummer, kundeID, navn, email, telefon, statusID);
        return "redirect:/LejekontraktAdministration"; // Tilbage til administrationen
    }
    //4.Metode til at slette en lejekontrakt
    @GetMapping("/sletLejekontrakt/{lejekontraktID}")
    public String sletLejekontrakt(@PathVariable int lejekontraktID) {
        lejekontraktService.deleteLejekontrakt(lejekontraktID);
        return "redirect:/LejekontraktAdministration"; // Tilbage til lejekontraktadministration
    }
    //5. Metode til at søge efter lejekontrakter
    @GetMapping("/soegLejekontrakter")
    public String soegLejekontrakter(@RequestParam(required = false) String soegeord, Model model) {
        List<Lejekontrakt> resultater = lejekontraktService.searchLejekontrakter(soegeord);
        model.addAttribute("lejekontrakter", resultater);
        return "home/LejekontraktAdministration"; // Genbrug skabelon til visning
    }
}

