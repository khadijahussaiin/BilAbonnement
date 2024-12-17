package com.example.bilabonnement.Controller;
//Søren
import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Model.Lejekontrakt;
import com.example.bilabonnement.Service.LejekontraktService;
import com.example.bilabonnement.Service.UdlejeværdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UdlejeværdiController {
    @Autowired
    private LejekontraktService lejekontraktService;

    @Autowired
    private UdlejeværdiService udlejeværdiService;

    @GetMapping("/UdlejeværdiAdministration")
    public String ShowUdlejeværdi(Model model){
        List<Lejekontrakt> lejekontrakter = lejekontraktService.getAllLejekontraktInfo();
        model.addAttribute("lejekontrakter", lejekontrakter);

        // Hent antal og sum af aktive lejekontrakter
        Map<String, Object> stats = udlejeværdiService.getSumAntalogPris();
        model.addAttribute("antalAktive", stats.get("antalAktive"));
        model.addAttribute("sumAfPriser", stats.get("sumAfPriser"));

        return "/home/UdlejeværdiAdministration";
    }


}
