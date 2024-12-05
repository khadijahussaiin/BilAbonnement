package com.example.bilabonnement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UdlejeværdiController {
    @GetMapping("/UdlejeværdiAdministration")
    public String ShowUdlejeværdi(){
        return "/home/UdlejeværdiAdministration";
    }
}
