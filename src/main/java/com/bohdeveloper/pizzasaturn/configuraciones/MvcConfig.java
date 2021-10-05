package com.bohdeveloper.pizzasaturn.configuraciones;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("principal");
        registry.addViewController("/acceso").setViewName("tienda/index");
        registry.addViewController("/registro").setViewName("registro");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");

    }

}