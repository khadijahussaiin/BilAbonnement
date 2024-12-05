package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.Lejekontrakt;
import com.example.bilabonnement.Service.LejekontraktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LejekontraktController {

    @Autowired
    private LejekontraktService lejekontraktService;

    @GetMapping("/LejekontraktAdministrations")
    public String lejekontraktAdministration() {
        return "home/LejekontraktAdministration";
    }

    @GetMapping("/lejekontrakter")
    public List<Lejekontrakt> getAllLejekontrakter() {
        return lejekontraktService.getAllLejekontrakter();
    }

    // Tilføj flere endpoints efter behov

    @GetMapping("/LejekontraktAdministration")
    public String showLejekontrakt(Model model) {
        List<Lejekontrakt> lejekontrakter = lejekontraktService.getAllLejekontrakter();
        model.addAttribute("lejekontrakter", lejekontrakter);
        return "home/LejekontraktAdministration"; // Dette skal matche navnet på din HTML-fil uden ".html"
    }
}


