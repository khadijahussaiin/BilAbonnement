package com.example.bilabonnement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LejekontraktController {
    @GetMapping("/LejekontraktAdministration")
    public String ShowLejekontrakt() {
        return "/home/LejekontraktAdministration";
    }
}


