package be.ucll.herexamen.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

@Entity
@Table(name = "WERKNEMER")
public class Werknemer extends User {

 /*   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull
    @NotEmpty
    public String email;
    private String password;
    private String role;*/

  /*  public String getRoll() {
        return role;
    }

    public void setRoll() {
        this.role = "WERKNEMER";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

    @NotNull
    @NotEmpty
    public String name;
    @NotNull
    @NotEmpty
    public String lastName;

    @NotNull
    @NotEmpty
    public String cv;

    public String aangemeld;

    @OneToOne
    private Job currentJob;

    @OneToMany
    @MapKeyColumn(name = "jobID")
    private List<Job> jobs = new ArrayList<>();

    @NotEmpty
    private String geboorteJaar;

    private int leeftijd;

    public Werknemer(){
        setRole("WERKNEMER");
    }

    public Werknemer(String name, String lastName, String pw, String geboorteJaar, String email, String cv) throws ParseException {
        setName(name);
        setLastName(lastName);
        setPassword(pw);
        setEmail(email);
        setCv(cv);
        setDatum(new Date());
        setRole("WERKNEMER");
        setGeboorteJaar(geboorteJaar);
        setLeeftijd(calculateAge(geboorteJaar));
    }

    public Werknemer(String name, String lastName, String pw, String geboorteJaar, String email, String cv, Job job) throws ParseException {
        setName(name);
        setLastName(lastName);
        setPassword(pw);
        setEmail(email);
        setCv(cv);
        addJob(job);
        setDatum(new Date());
        setRole("WERKNEMER");
        setGeboorteJaar(geboorteJaar);
        setLeeftijd(calculateAge(geboorteJaar));
    }

    public void setDatum(Date datum) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        String DateToStr = format.format(datum);

        this.aangemeld = DateToStr;
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(Job currentJob) {
        this.currentJob = currentJob;
    }

    public String getGeboorteJaar() {
        return geboorteJaar;
    }

    public void setGeboorteJaar(String geboorteJaar) {
        this.geboorteJaar = geboorteJaar;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getAangemeld() {
        return aangemeld;
    }

    public void setAangemeld(String aangemeld) {
        this.aangemeld = aangemeld;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void addJob(Job job){
        jobs.add(job);
    }

    public int  calculateAge(String geboorteJaar) throws ParseException {
        String sDate1= geboorteJaar;
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        LocalDate ld = date1.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        Period diff = Period.between(ld, LocalDate.now());
        return diff.getYears();
    }

    public void addNewCurrentJob(Job j) throws Exception {
        if (currentJob == null) {
            setCurrentJob(j);
            addJob(j);
        }
        else throw new Exception("already has a current job");
    }


    /* public Map<Integer, Job> getJobs() {
        return this.jobs;
    }

    public void setWeek(Map<Integer, Job> jobs) {
        this.jobs = jobs;
    }

    public void addJob(Job job) {
        this.jobs.put(job.getJobID(), job);
    }

    public void deleteJob(Job job) {
        this.jobs.remove(job.getJobID());
    }

    public boolean jobsIsEmpty(){ return jobs.isEmpty(); }*/
}
