import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.model.Werknemer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public final class WerknemerBuilder {
    public String name;
    public String lastName;
    public String cv;
    public String aangemeld;
    private int id;
    private String password;
    private String email;
    private String role = "ROLE_WERKNEMER";
    private Job currentJob;
    private List<Job> jobs = new ArrayList<>();
    private String geboorteJaar;
    private int leeftijd;

    private WerknemerBuilder() {
    }

    public static WerknemerBuilder aWerknemer() {
        return new WerknemerBuilder();
    }

    public static WerknemerBuilder anOKWerknemer(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String ww = "pw";
        String origenal = encoder.encode(ww);
        return aWerknemer().withId(1)
                .withPassword(ww)
                .withEmail("epic@gamer.be")
                .withName("epic")
                .withLastName("gamer")
                .withAangemeld("20/09/2009")
                .withCv("afgestuurd")
                .withGeboorteJaar("20/10/2000");
    }
    public static WerknemerBuilder alsoOKWerknemer(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String ww = "pw";
        String origenal = encoder.encode(ww);
        return aWerknemer().withId(9)
                .withPassword(ww)
                .withEmail("sad@gamer.be")
                .withName("sad")
                .withLastName("sddd")
                .withAangemeld("20/09/2009")
                .withCv("9ofzo")
                .withGeboorteJaar("20/10/2000");
    }
    public WerknemerBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public WerknemerBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public WerknemerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public WerknemerBuilder withRole(String role) {
        this.role = role;
        return this;
    }

    public WerknemerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public WerknemerBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public WerknemerBuilder withCv(String cv) {
        this.cv = cv;
        return this;
    }

    public WerknemerBuilder withAangemeld(String aangemeld) {
        this.aangemeld = aangemeld;
        return this;
    }

    public WerknemerBuilder withCurrentJob(Job currentJob) {
        this.currentJob = currentJob;
        return this;
    }

    public WerknemerBuilder withJobs(List<Job> jobs) {
        this.jobs = jobs;
        return this;
    }

    public WerknemerBuilder withGeboorteJaar(String geboorteJaar) {
        this.geboorteJaar = geboorteJaar;
        return this;
    }

    public WerknemerBuilder withLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
        return this;
    }

    public Werknemer build() throws ParseException {
        Werknemer werknemer = new Werknemer();
        werknemer.setId(id);
        werknemer.setPassword(password);
        werknemer.setEmail(email);
        werknemer.setRole(role);
        werknemer.setName(name);
        werknemer.setLastName(lastName);
        werknemer.setCv(cv);
        werknemer.setAangemeld(aangemeld);
        werknemer.setCurrentJob(currentJob);
        werknemer.setJobs(jobs);
        werknemer.setGeboorteJaar(geboorteJaar);
        werknemer.setLeeftijd(leeftijd);
        return werknemer;
    }
}
