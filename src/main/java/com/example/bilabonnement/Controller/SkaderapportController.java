package com.example.bilabonnement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SkaderapportController {
    @GetMapping("/SkaderapportAdministration")
    public String ShowSkaderapport(){
        return "/home/SkaderapportAdministration";
    }
}
