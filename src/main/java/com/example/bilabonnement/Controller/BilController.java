package com.example.bilabonnement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BilController {
    @GetMapping("/BilAdministration")
    public String ShowBil(){
        return "/home/BilAdministration";
    }
}
