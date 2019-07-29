package be.ucll.herexamen.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity

public class Job {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotEmpty
    private String beschrijving;

    @NotEmpty
    private String duur;

    private String datum;

    private String jobStatus;
    @NotEmpty
    private String details;

    @NotNull
    @ManyToOne(cascade = CascadeType.DETACH)
    private Werkgever werkgever;

   /* @ManyToOne(cascade = CascadeType.DETACH)
    private Werknemer werknemer;*/

    public Job(){
        setDatum(new Date());
    }


    public Job(String beschrijving, String duur, String details, Werkgever werkgever){
        setBeschrijving(beschrijving);
        setDuur(duur);
        setDetails(details);
        setWerkgever(werkgever);
        setDatum(new Date());
        setJobStatus("Beschikbaar");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeschrijving() {
        return beschrijving.toLowerCase();
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getDuur() {
        return duur;
    }

    public void setDuur(String duur) {
        this.duur = duur;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        String DateToStr = format.format(datum);

        this.datum = DateToStr;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public void setDatum(String datum) {
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

   /* public Werknemer getWerknemer() {
        return werknemer;
    }

    public void setWerknemer(Werknemer werknemer) {
        this.werknemer = werknemer;
    }*/

    public void updateJob(Job job){
        setDatum(job.getDatum());
        setBeschrijving(job.getBeschrijving());
        setDuur(job.getDuur());
        setDetails(job.getDetails());
        /*setWerkgever(job.getWerkgever());*/
    }
}
