package be.ucll.herexamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@org.springframework.stereotype.Controller

public class JobsController implements WebMvcConfigurer{

    @GetMapping("/index")
    public String index() { return "index";}


    @GetMapping("/overzicht")
    public String overzicht() {

        return "overzicht";
    }
}
