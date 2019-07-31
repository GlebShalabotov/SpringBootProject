package be.ucll.herexamen.controller;

import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.model.MyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@org.springframework.stereotype.Controller

public class JobsController implements WebMvcConfigurer{

    @Autowired
    private MyService myService;

    @GetMapping("/index")
    public String index() { return "index";}


    @GetMapping("/overzicht")
    public String overzicht( Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            if((myService.findRoleWerknemerByMail(currentUserName)).equals("WERKNEMER")){
                model.addAttribute("jobs", myService.getAllBeschikbareJobs());
                return "aannemen";
            }
        }

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

    @GetMapping("/aanpassen")
    public String aanpassen(Model model) {
        model.addAttribute("jobs", myService.getAllJobs());
        return "aanpassen";}

    @GetMapping("/aanpassen/update/{id}")
    public String updatePageOfJob(@PathVariable("id") int id, Model model){
        Job job = myService.findJobById(id);
        model.addAttribute("oldJob", job);
        return "update";
    }

    @PostMapping("/aanpassen/update/{id}")
    public String updateJob(Model model, @Valid Job job, @PathVariable("id") int id,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            model.addAttribute("oldJob" ,myService.findJobById(id));
            return "update";
        } else {
            myService.updateJob(id, job);
            model.addAttribute("jobs", myService.getAllJobs());
            return "overzicht";
        }
    }
    @GetMapping("/aanpassen/verwijder/{id}")
    public String verwijderJob(@PathVariable("id") int id, Model model){
        Job job = myService.findJobById(id);
        model.addAttribute("job", job);
        return "verwijder";
    }

    @GetMapping("/aanpassen/verwijder/bevestigd/{id}")
    public String bevestigVerwijderingVanJob (@PathVariable("id") int id, Model model){
        myService.deleteJobById(id);
        model.addAttribute("jobs", myService.getAllJobs());
        return "overzicht";
    }

    @GetMapping("/aannemen/{id}")
    public String jobAannemen( @PathVariable("id") int id, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String wnEmail = authentication.getName();
            myService.addJobToWN(wnEmail, id);
        }

        return "overzicht";
    }

    @GetMapping("/accesDenied")
    public String error(Model model){
        return "accesDenied";
    }

}
