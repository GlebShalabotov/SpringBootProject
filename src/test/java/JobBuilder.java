import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.model.Werkgever;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JobBuilder {

    private int id;
    private String beschrijving;
    private String duur;
    private String datum;
    private String jobStatus;
    private String details;
    private Werkgever werkgever;

    private JobBuilder(){

    }


    public static  JobBuilder aJob(){
        return new JobBuilder();
    }
    public static JobBuilder anOKJob(){
        Werkgever wg = WerkgeverBuilder.anOKWerkgever().build();
        return aJob().withId(10)
                .withBeschrijving("Sales Manager")
                .withDuur("vast")
                .withDatum(new Date())
                .withJobStatus("beschikbaar")
                .withDetails("+20jaar")
                .withWerkgever(wg);
    }

    public static JobBuilder anOtherOKJob(){
        Werkgever wg = WerkgeverBuilder.anOKWerkgever().build();
        return aJob().withId(30)
                .withBeschrijving("OKOKOK")
                .withDuur("HIER EN DAAR")
                .withDatum(new Date())
                .withJobStatus("beschikbaar")
                .withDetails("ALLES IS OK")
                .withWerkgever(wg);
    }
    public static JobBuilder nOKJob(){
        Werkgever wg = WerkgeverBuilder.anOtherOKWerkgever().build();
        return aJob().withId(50)
                .withBeschrijving("Sales Manager")
                .withDatum(new Date())
                .withJobStatus("voldaan")
                .withDetails("+20jaar")
                .withWerkgever(wg);
    }

    public static JobBuilder sameJobAsOKJOBDifferentDetailsAndBeschrijving(){
        Werkgever wg = WerkgeverBuilder.anOKWerkgever().build();
        return aJob().withId(22)
                .withBeschrijving("Anders")
                .withDuur("vast")
                .withDatum(new Date())
                .withJobStatus("beschikbaar")
                .withDetails("Anders")
                .withWerkgever(wg);
    }
    public JobBuilder withId(int id){
        this.id = id;
        return this;
    }

    public JobBuilder withBeschrijving(String beschrijving){
        this.beschrijving = beschrijving;
        return this;
    }

    public JobBuilder withDuur(String duur){
        this.duur = duur;
        return this;
    }

    public JobBuilder withDatum(Date datum){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        String DateToStr = format.format(datum);

        this.datum = DateToStr;
        return this;
    }

    public JobBuilder withJobStatus(String status){
        this.jobStatus = status;
        return this;
    }

    public JobBuilder withDetails (String details){
        this.details = details;
        return this;
    }

    public JobBuilder withWerkgever (Werkgever werkgever){
        this.werkgever = werkgever;
        return this;
    }

    public Job build(){
        Job job = new Job();
        job.setId(id);
        job.setBeschrijving(beschrijving);
        job.setDuur(duur);
        job.setDatum(datum);
        job.setDetails(details);
        job.setJobStatus(jobStatus);
        job.setWerkgever(werkgever);
        return job;
    }

}
