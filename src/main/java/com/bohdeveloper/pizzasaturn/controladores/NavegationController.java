package com.bohdeveloper.pizzasaturn.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegationController {
    
    @GetMapping("/")
    public String goIndex(){
        return "index";
    }

    @GetMapping("/registro")
    public String goRegistro(){
        return "registro";
    }

    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }


}
