package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.Lejekontrakt;
import com.example.bilabonnement.Service.LejekontraktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LejekontraktController {

    @Autowired
    private LejekontraktService lejekontraktService;

    @GetMapping("/LejekontraktAdministration")
    public String getLejekontrakter(Model model) {
        List<Lejekontrakt> lejekontrakter = lejekontraktService.getAllLejekontrakter();
        model.addAttribute("lejekontrakter", lejekontrakter);
        return "home/LejekontraktAdministration"; // Dette peger på en Thymeleaf-skabelon kaldet lejekontrakter.html
    }
    @GetMapping("/OpretLejekontrakt")
    public String visOpretLejekontraktForm(Model model) {
        model.addAttribute("lejekontrakt", new Lejekontrakt()); // Vi giver en tom kontrakt til formularen
        return "home/OpretLejekontrakt"; // Dette peger på en Thymeleaf-skabelon kaldet OpretLejekontrakt.html
    }
    @PostMapping("/OpretLejekontrakt")
    public String opretLejekontrakt(Lejekontrakt lejekontrakt) {
        lejekontraktService.opretLejekontrakt(lejekontrakt);
        return "redirect:/LejekontraktAdministration"; // Efter oprettelse, redirect til administrationen
    }
}


