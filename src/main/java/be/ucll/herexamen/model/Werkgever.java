package be.ucll.herexamen.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Werkgever extends User{

  /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String email;


    private String role;*/

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String telefoon;

    @NotNull
    @NotEmpty
    private String aangemeld;


    private String bedrijf;

    private int score;


    /*@OneToMany(cascade = CascadeType.ALL)
    @MapKeyColumn(name = "jobID")
    private List<Job> jobs = new ArrayList<>();
    public void addJob(Job job){
        jobs.add(job);
    }*/
    public Werkgever(){
        setRole("WERKGEVER");
    }


    public Werkgever(String name, String lastName, String password,  String email, String telefoon){
        setName(name);
        setLastName(lastName);
        setPassword(password);
        setTelefoon(telefoon);
        setEmail(email);
        setAangemeldMetDatum(new Date());
        setRole("WERKGEVER");
        setBedrijf("NVT");
    }

    public Werkgever(String name, String lastName, String password, String email,  String telefoon, String bedrijf){
        setName(name);
        setLastName(lastName);
        setPassword(password);
        setTelefoon(telefoon);
        setEmail(email);
        setAangemeldMetDatum(new Date());
        setRole("WERKGEVER");
        setBedrijf(bedrijf);
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
/*
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoll() {
        return role;
    }

    public void setRoll() {
        this.role = "WERKGEVER";
    }*/

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getBedrijf() {
        return bedrijf;
    }

    public void setBedrijf(String bedrijf) {
        this.bedrijf = bedrijf;
    }

    public String getAangemeld() {
        return aangemeld;
    }

    public void setAangemeld(String aangemeld) {
        this.aangemeld = aangemeld;
    }
    public void setAangemeldMetDatum(Date aangemeld){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        String DateToStr = format.format(aangemeld);
        this.aangemeld = DateToStr;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



}
