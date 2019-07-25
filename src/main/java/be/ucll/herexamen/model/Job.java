package be.ucll.herexamen.model;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


public class Job {
    @NotNull
    @NotEmpty
    private int jobID;

    @NotNull
    @NotEmpty
    private String beschrijving;

    @NotNull
    @NotEmpty
    private double duur;

    @NotNull
    @NotEmpty
    private Date datum;

    @NotNull
    @NotEmpty
    private String details;

    private Werkgever werkgever;

    private Werknemer werknemer;

    public Job(int jobID, String beschrijving, double duur, String details, Werkgever werkgever){
        setJobID(jobID);
        setBeschrijving(beschrijving);
        setDuur(duur);
        setDetails(details);
        setWerkgever(werkgever);
        setDatum(new Date());
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getDuur() {
        return duur;
    }

    public void setDuur(double duur) {
        this.duur = duur;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Werkgever getWerkgever() {
        return werkgever;
    }

    public void setWerkgever(Werkgever werkgever) {
        this.werkgever = werkgever;
    }

    public Werknemer getWerknemer() {
        return werknemer;
    }

    public void setWerknemer(Werknemer werknemer) {
        this.werknemer = werknemer;
    }
}
