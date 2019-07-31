package be.ucll.herexamen.model;

import be.ucll.herexamen.repositry.JobsRepository;
import be.ucll.herexamen.repositry.WerkgeverRepository;
import be.ucll.herexamen.repositry.WerknemerRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.stereotype.Service
public class MyService {


    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    WerknemerRepository werknemerRepository;

    @Autowired
    WerkgeverRepository werkgeverRepository;

    private List<Job> jobs =  new ArrayList<>();

    private List<Werkgever> werkgevers = new ArrayList<>();

    private List<Werknemer> werknemers = new ArrayList<>();





    public MyService() {

    }

    public Job findJobById(int id){
        return jobsRepository.findById(id);
    }

    public Job getJobById(int id) {
        return jobsRepository.findById(id);
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Werkgever> getWerkgevers() {
        return werkgevers;
    }

    public void setWerkgevers(List<Werkgever> werkgevers) {
        this.werkgevers = werkgevers;
    }

    public List<Werknemer> getWerknemers() {
        return werknemers;
    }

    public void setWerknemers(List<Werknemer> werknemers) {
        this.werknemers = werknemers;
    }

    // JOB
    public void addJob(Job job) {
        addWerkgever(job.getWerkgever());
        jobsRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobsRepository.findAll();
    }

    public List <Job> getAllBeschikbareJobs(){
        return jobsRepository.findByJobStatus("Beschikbaar");
    }

    // WG
    private void addWerkgever(Werkgever werkgever) {

        Werkgever werkgever1 = werkgeverRepository.findByEmail(werkgever.getEmail());
        if ( werkgever1 == null){
            werkgeverRepository.save(werkgever);
        }
    }

    public List<Job> getJobByBeschrijving(String beschrijving) {
        List<Job> jobsByBeschrijving = new ArrayList<>();
        for( Job j: jobs ){
            if(j.getBeschrijving().contains(beschrijving.toLowerCase())) jobsByBeschrijving.add(j);
        }
        return jobsByBeschrijving;
    }

    public void updateJob(int id, Job changedJob) {
        Job j = getJobById(id);
        j.updateJob(changedJob);
        jobsRepository.save(j);
    }

    public void updateJobZonderId(Job job){
        jobsRepository.save(job);
    }


    public void deleteJobById(int id) {
        Job j = getJobById(id);
        jobsRepository.delete(j);
    }

    // WN
    public void addJobToWN(String wnEmail, int id) {
        Werknemer wn = werknemerRepository.findByEmail(wnEmail);
        Job j = jobsRepository.findById(id);
        j.setJobStatus("Volzet");
        jobsRepository.save(j);
        wn.addJob(j);
        werknemerRepository.save(wn);
    }

    public String findRoleWerknemerByMail(String wnEmail){
        Werknemer wn = werknemerRepository.findByEmail(wnEmail);
        String role = wn.getRoll();
        return role;
    }
}
