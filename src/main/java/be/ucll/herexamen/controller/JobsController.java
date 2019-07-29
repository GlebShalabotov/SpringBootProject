package be.ucll.herexamen.controller;

import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.model.MyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@org.springframework.stereotype.Controller

public class JobsController implements WebMvcConfigurer{

    @Autowired
    private MyService myService;

    @GetMapping("/index")
    public String index() { return "index";}


    @GetMapping("/overzicht")
    public String overzicht(Model model) {
        model.addAttribute("jobs", myService.getAllJobs());
        return "overzicht";
    }

    @GetMapping("/overzicht/details/{id}")
    public String detailsJob(@PathVariable("id") int id, Model model){
        Job job = myService.findJobById(id);
        model.addAttribute("job", job);
        return "details";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
    @PostMapping("/toevoegen/add")
    public String nieuweJobToevoegen(Model model, @Valid Job job, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "toevoegen";
        } else {
            myService.addJob(job);
            model.addAttribute("courses", myService.getAllJobs());
            return "overzicht";
        }
    }

    @GetMapping("/toevoegen")
    public String toevoegen(Model model){
        return "toevoegen";
    }
}
