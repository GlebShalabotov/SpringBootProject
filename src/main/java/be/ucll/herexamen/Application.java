package be.ucll.herexamen;


import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.model.Werkgever;
import be.ucll.herexamen.model.Werknemer;
import be.ucll.herexamen.repositry.JobRepository;
import be.ucll.herexamen.repositry.WerkgeverRepository;
import be.ucll.herexamen.repositry.WerknemerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Order(1)
    public CommandLineRunner runnerCourses(WerkgeverRepository werkgeverRepository) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String ww = "pw";
        String origanal = encoder.encode(ww);
        return CoursesArgs -> {
            werkgeverRepository.save(new Werkgever("Elise", "De Craene", origanal, "elise@lol.be" , "0488337746" ,"VanakenBroek"));
            werkgeverRepository.save(new Werkgever("Bob", "MechelBroek", origanal, "mechel@broek.be" , "048982983"));
            werkgeverRepository.save(new Werkgever("Stijn", "Njits", origanal,"Destroyer@worlds.be" , "0400003872", "Telenet"));
        };
    }

   @Bean
    @Order(2)
    public CommandLineRunner runnerJobs (JobRepository jobsRepository, WerkgeverRepository werknemerRepository){
        return JobsArgs -> {
            jobsRepository.save(new Job("sales manager", "3 maanden", "7 jaar ervaring", werknemerRepository.findByEmail("elise@lol.be")));
            jobsRepository.save(new Job("netwerk beheerder Junior", "Vast Contract", "+18","volzet", werknemerRepository.findByEmail("mechel@broek.be")));
            jobsRepository.save(new Job("team-leader", "Part-Time", "team project voor softMicro", werknemerRepository.findByEmail("Destroyer@worlds.be")));
        };
    }

    @Bean
    @Order(3)
    public CommandLineRunner runnerWerknemers (WerknemerRepository werknemerRepository, JobRepository jobsRepository){
        return WerknemerArgs -> {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String ww = "pw";
            String origanal = encoder.encode(ww);
            werknemerRepository.save(new Werknemer("Jan","DeManDieAllesKan", origanal, "20/03/2000", "jan@deman.be", "ict", jobsRepository.findById(2)));
            werknemerRepository.save(new Werknemer("Luck","Gast", origanal, "20/03/1980","gast@kerel.be", "HBO"));

        };


    }


}