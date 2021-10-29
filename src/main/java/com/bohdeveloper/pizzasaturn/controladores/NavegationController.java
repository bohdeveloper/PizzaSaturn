package com.bohdeveloper.pizzasaturn.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegationController {
    /* registry.addViewController("/").setViewName("index");
    registry.addViewController("/tienda").setViewName("tienda/index");
    registry.addViewController("/registro").setViewName("registro");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/contacto").setViewName("contacto"); */

    @GetMapping("/")
    public String goIndex(HttpServletRequest request) {
        request.setAttribute("mensaje", "Mensaje de prueba");
        return "index";
    }
}
