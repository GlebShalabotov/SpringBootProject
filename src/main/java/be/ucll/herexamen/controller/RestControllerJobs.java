package be.ucll.herexamen.controller;

import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.model.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestControllerJobs {

    @Autowired
    MyService myService;

    @PostMapping("/toevoegen")
    @ResponseStatus(HttpStatus.CREATED)
    public Job createNewJob (@RequestBody @Valid Job job){
        myService.addJob(job);
        return job;
    }

    @GetMapping("/getalljobs")
    public List<Job> getAllJobs (Model model){
        return myService.getJobs();
    }

    @GetMapping("/jobs/jobID/{id}")
    public Job getJobByjobID(@PathVariable("id") int id){
        return myService.findJobById(id);
    }

    @GetMapping("/jobs/beschrijving/{beschrijving}")
    public List<Job> getJobByBeschrijving (@PathVariable("beschrijving") String beschrijving){
        return myService.getJobByBeschrijving(beschrijving);
    }

    @PutMapping("jobs/update/{id}")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Job editSpecificWholeJob(@PathVariable("id") int id, @RequestBody @Valid Job changedJob) {
        return myService.updateJob(id, changedJob);
    }

}
