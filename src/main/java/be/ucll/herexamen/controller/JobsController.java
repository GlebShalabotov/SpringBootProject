package be.ucll.herexamen.controller;

import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.model.MyService;
import be.ucll.herexamen.model.User;
import be.ucll.herexamen.model.Werknemer;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.RedirectView;

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
        setUser(model);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            Werknemer nm = myService.findWerknemerByMail(currentUserName);
            if((nm.getRole()).equals("WERKNEMER")){
                model.addAttribute("jobs", myService.getAllBeschikbareJobs());
                return "aannemen";}
            }
        model.addAttribute("jobs", myService.getAllJobs());
        return "overzicht";
    }

    @GetMapping("/overzicht/details/{id}")
    public String detailsJob(@PathVariable("id") int id, Model model){
        setUser(model);
        Job job = myService.findJobById(id);
        model.addAttribute("job", job);
        return "details";
    }

    @GetMapping("/login")
    public String login(Model model){
        setUser(model);
        return "login";
    }
    @PostMapping("/toevoegen/add")
    public String nieuweJobToevoegen(Model model, @Valid Job job, BindingResult bindingResult){
        setUser(model);
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
        setUser(model);
        return "toevoegen";
    }

    @GetMapping("/aanpassen")
    public String aanpassen(Model model) {
        setUser(model);
        model.addAttribute("jobs", myService.getAllJobs());
        return "aanpassen";}

    @GetMapping("/aanpassen/update/{id}")
    public String updatePageOfJob(@PathVariable("id") int id, Model model){
        setUser(model);
        Job job = myService.findJobById(id);
        model.addAttribute("oldJob", job);
        return "update";
    }

    @PostMapping("/aanpassen/update/{id}")
    public  ModelAndView updateJob(ModelMap model, @Valid Job job, @PathVariable("id") int id,BindingResult bindingResult){
        setUser(model);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            model.addAttribute("oldJob" ,myService.findJobById(id));
            return new ModelAndView("redirect:/update", model);
        } else {
            myService.updateJob(id, job);
            model.addAttribute("jobs", myService.getAllJobs());
            return  new ModelAndView("redirect:/overzicht", model);
        }
    }
    @GetMapping("/aanpassen/verwijder/{id}")
    public String verwijderJob(@PathVariable("id") int id, Model model){
        setUser(model);
        Job job = myService.findJobById(id);
        model.addAttribute("job", job);
        return "verwijder";
    }

    @GetMapping("/aanpassen/verwijder/bevestigd/{id}")
    public String bevestigVerwijderingVanJob (@PathVariable("id") int id, Model model){
        setUser(model);
        myService.deleteJobById(id);
        model.addAttribute("jobs", myService.getAllJobs());
        return "overzicht";
    }

    @GetMapping("/aannemen/{id}")
    public ModelAndView jobAannemen(@PathVariable("id") int id, ModelMap model) throws Exception {
        setUser(model);

        Werknemer nm = myService.findWerknemerByMail(getEmailUser());

        if((nm.getRole()).equals("WERKNEMER")){
            if(nm.getCurrentJob() == null){
                String wnEmail = getEmailUser();
                myService.addJobToWN(wnEmail, id);
                return new ModelAndView("redirect:/overzicht", model);}
            else{
                model.addAttribute("job",myService.getCurrentJobOfWerknemer(nm));
                return new ModelAndView("redirect:/huidigejob", model);
            }
        }
        model.addAttribute("jobs", myService.getAllBeschikbareJobs());
        return new ModelAndView("redirect:/overzicht", model);
    }

    @GetMapping("/accesDenied")
    public String error(Model model){

        setUser(model);
        return "accesDenied";
    }

    @GetMapping("/huidigejob")
    public String huidigeJob(Model model){
        setUser(model);
        Werknemer user = (Werknemer) getCurrentUser();
        model.addAttribute("job", user.getCurrentJob());
        return "huidigejob";
    }

    @GetMapping("/profiel")
    public String  profiel(Model model){
        setUser(model);
        model.addAttribute("user", getCurrentUser());
        return "profiel";
    }

    public String getEmailUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return currentUserName;
    }


    public String getUserRole(){
        String mail = getEmailUser();
        String role = myService.findRoleUserByMail(mail);
        return role;
    }

    public User getCurrentUser(){
        String mail = getEmailUser();
        User user = myService.findUserByMail(mail);
        return user;
    }

    public void setUser(Model model){
        model.addAttribute("user", getCurrentUser());
    }

    public void setUser(ModelMap model){
        model.addAttribute("user", getCurrentUser());
    }

}
