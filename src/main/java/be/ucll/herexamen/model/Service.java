package be.ucll.herexamen.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.stereotype.Service
public class Service {

    private List<Job> jobs =  new ArrayList<>();

    private List<Werkgever> werkgevers = new ArrayList<>();

    private List<Werknemer> werknemers = new ArrayList<>();

    private AtomicInteger nextId = new AtomicInteger();



    public Service() {
        Werkgever elise = new Werkgever("Elise", "De Craene", "elise@lol.be" , "0488337746");
        Werkgever bob = new Werkgever("Bob", "MechelBroek", "mechel@broek.be" , "048982983");
        Werkgever stijn = new Werkgever("Stijn", "Njits", "Destroyer@worlds.be" , "0400003872");

        Job job_1 = new Job(nextId.getAndIncrement(),"Vast", 99.99, "7 jaar ervaring", elise);
        Job job_2 = new Job(nextId.getAndIncrement(), "part-time", 3, "+18", bob);
        Job job_3 = new Job(nextId.getAndIncrement(), "project", 80, "team project voor softMicro" , stijn);

        jobs.add(job_1);
        jobs.add(job_2);
        jobs.add(job_3);

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

    public AtomicInteger getNextId() {
        return nextId;
    }

    public void setNextId(AtomicInteger nextId) {
        this.nextId = nextId;
    }
}
