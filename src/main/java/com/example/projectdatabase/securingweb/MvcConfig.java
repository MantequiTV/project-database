package com.example.projectdatabase.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("product/list");
        registry.addViewController("/list").setViewName("product/list");
        registry.addViewController("/product/show/{id}").setViewName("product/show");
        registry.addViewController("product/edit/{id}").setViewName("product/productform");
        registry.addViewController("/product/new").setViewName("product/productform");
        registry.addViewController("/product").setViewName("product/productform");
        registry.addViewController("/product/delete/{id}").setViewName("product/list");

        registry.addViewController("/login").setViewName("login");
    }

}