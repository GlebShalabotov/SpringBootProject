import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.model.MyService;
import be.ucll.herexamen.model.Werkgever;
import be.ucll.herexamen.model.Werknemer;
import be.ucll.herexamen.repositry.JobRepository;
import be.ucll.herexamen.repositry.UserRepository;
import be.ucll.herexamen.repositry.WerkgeverRepository;
import be.ucll.herexamen.repositry.WerknemerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class ServiceUnitTest {


    @TestConfiguration
    static class JobServiceTestContextConfigeration {

        @Bean
        public MyService myService() {
            return new MyService();
        }
    }

    @Autowired
    private MyService myService;

    @MockBean
    private JobRepository jobsRepository;

    @MockBean
    private WerknemerRepository werknemerRepository;

    @MockBean
    private WerkgeverRepository werkgeverRepository;

    @MockBean
    private UserRepository userRepository;

    private Job okJob, nOKjob, anotherOKJob, maybeOKJob,andereJob;
    private Werkgever okWG, alsoOKWG;
    private Werknemer okWN, alsoOKWN;
    private List<Job> jobs,beschikbareJobs,glebsJobs,deltejobs;
    private List<Werkgever> werkgeversList;
    private List<Werknemer> werknemerList;

    @Before
    public void setUp() throws ParseException {
        okJob = JobBuilder.anOKJob().build();
        nOKjob = JobBuilder.nOKJob().build();
        andereJob = JobBuilder.sameJobAsOKJOBDifferentDetailsAndBeschrijving().build();
        anotherOKJob = JobBuilder.anOtherOKJob().build();
        okWN = WerknemerBuilder.anOKWerknemer().build();
        alsoOKWN = WerknemerBuilder.alsoOKWerknemer().build();
        jobs = new ArrayList<Job>();
        jobs.add(okJob);
        jobs.add(nOKjob);
        jobs.add(anotherOKJob);
        beschikbareJobs = new ArrayList<Job>();
        glebsJobs = new ArrayList<Job>();
        deltejobs = new ArrayList<Job>();
        deltejobs.add(anotherOKJob);
        werknemerList = new ArrayList<>();
        werknemerList.add(okWN);
        werknemerList.add(alsoOKWN);
        werkgeversList = new ArrayList<>();
        for(Job j:jobs){
            if(j.getJobStatus() != null){
                if(j.getJobStatus().equals("beschikbaar")) beschikbareJobs.add(j);
            }
            if(j.getWerkgever().getId()== 2) glebsJobs.add(j);
        }

        okWG = WerkgeverBuilder.anOKWerkgever().build();
        alsoOKWG = WerkgeverBuilder.anOtherOKWerkgever().build();
        werkgeversList.add(okWG);
        werkgeversList.add(alsoOKWG);

    }

    @Test
    public void should_find_job_by_given_id() {
        Mockito.when(jobsRepository.findById(okJob.getId())).thenReturn(okJob);

        int id = okJob.getId();
        String beschrijving = okJob.getBeschrijving();
        String duur = okJob.getDuur();
        String jobstatus = okJob.getJobStatus();
        String details = okJob.getDetails();
        Werkgever werkgever = okJob.getWerkgever();
        String datum = okJob.getDatum();

        Job found = myService.findJobById(id);

        assertThat(found.getId()).isEqualTo(id);
        assertThat(found.getBeschrijving()).isEqualTo(beschrijving);
        assertThat(found.getDetails()).isEqualTo(details);
        assertThat(found.getDuur()).isEqualTo(duur);
        assertThat(found.getDatum()).isEqualTo(datum);
        assertThat(found.getWerkgever()).isEqualTo(werkgever);
        assertThat(found.getJobStatus()).isEqualTo(jobstatus);

    }


    @Test
    public void job_is_added_when_al_values_are_correct(){
        Mockito.when(jobsRepository.save(okJob)).thenReturn(okJob);

        Job job = myService.addJob(okJob);

        assertThat(job.getJobStatus()).isEqualTo(okJob.getJobStatus());
        assertThat(job.getDatum()).isEqualTo(okJob.getDatum());
        assertThat(job.getBeschrijving()).isEqualTo(okJob.getBeschrijving());

    }

    @Test
    public void should_find_all_jobs(){
        Mockito.when(jobsRepository.findAll()).thenReturn(jobs);

        List<Job> foundedJobs = jobsRepository.findAll();

        assertThat(foundedJobs.size()).isEqualTo(3);
        assertThat(foundedJobs).contains(anotherOKJob);
        assertThat(foundedJobs).contains(nOKjob);
        assertThat(foundedJobs).contains(okJob);

    }


    @Test
    public void should_find_all_beschikbare_jobs(){
        Mockito.when(jobsRepository.findByJobStatus("beschikbaar")).thenReturn(beschikbareJobs);

        List<Job> foundedBeschikbareJobs = jobsRepository.findByJobStatus("beschikbaar");

        assertThat(foundedBeschikbareJobs).contains(okJob);
        assertThat(foundedBeschikbareJobs).contains(anotherOKJob);
        assertThat(foundedBeschikbareJobs).doesNotContain(nOKjob);
    }


    @Test
    public void should_find_all_jobs_of_werkgever(){
        Mockito.when(jobsRepository.findAllByWerkgeverId(2)).thenReturn(glebsJobs);

        List<Job> foundenWGJobs = jobsRepository.findAllByWerkgeverId(2);

        assertThat(foundenWGJobs).contains(okJob);
        assertThat(foundenWGJobs).doesNotContain(nOKjob);
    }

    @Test
    public void should_find_all_werkgevers(){
        Mockito.when(werkgeverRepository.findAll()).thenReturn(werkgeversList);

        List<Werkgever> foundWerkgevers = werkgeverRepository.findAll();

        assertThat(foundWerkgevers).contains(okWG);
        assertThat(foundWerkgevers).contains(alsoOKWG);
    }

    @Test
    public void should_find_werkgever_by_mail(){
        Mockito.when(werkgeverRepository.findByEmail(okWG.getEmail())).thenReturn(okWG);

        Werkgever wg = werkgeverRepository.findByEmail(okWG.getEmail());

        assertThat(wg).isEqualTo(okWG);
    }


    @Test
    public void should_update_job_with_id (){
        Mockito.when(jobsRepository.save(okJob)).thenReturn(okJob);

        Mockito.when(jobsRepository.findById(okJob.getId())).thenReturn(okJob);
        Mockito.when(jobsRepository.findById(anotherOKJob.getId())).thenReturn(anotherOKJob);



        myService.updateJob(anotherOKJob.getId(), anotherOKJob);
        Job job = jobsRepository.findById(anotherOKJob.getId());

            assertThat(job).isEqualTo(anotherOKJob);
    }

    @Test
    public void should_update_job_without_id (){
        Mockito.when(jobsRepository.save(okJob)).thenReturn(okJob);

        Mockito.when(jobsRepository.findById(okJob.getId())).thenReturn(okJob);
        Mockito.when(jobsRepository.findById(anotherOKJob.getId())).thenReturn(anotherOKJob);



        myService.updateJobZonderId(anotherOKJob);
        Job job = jobsRepository.findById(anotherOKJob.getId());

        assertThat(job).isEqualTo(anotherOKJob);
    }

    @Test
    public void should_delete_job(){
        Mockito.when(jobsRepository.save(anotherOKJob)).thenReturn(anotherOKJob);
        Mockito.when(jobsRepository.save(okJob)).thenReturn(okJob);
        Mockito.when(jobsRepository.findAll()).thenReturn(deltejobs);

        myService.deleteJobById(okJob.getId());

        assertThat(myService.getAllJobs()).contains(anotherOKJob);
        assertThat(myService.getAllJobs()).doesNotContain(okJob);
    }

    @Test
    public void should_find_all_werknemers(){
        Mockito.when(werknemerRepository.findAll()).thenReturn(werknemerList);

        List<Werknemer> foundWN = myService.findAllWerknemers();

        assertThat(foundWN).contains(okWN);
        assertThat(foundWN).contains(alsoOKWN);
    }

    @Test
    public void should_find_Werknemer_by_id(){
        Mockito.when(werknemerRepository.findByEmail(okWN.getEmail())).thenReturn(okWN);

        Werknemer wn = myService.findWerknemerByMail(okWN.getEmail());
        assertThat(wn).isEqualTo(okWN);
    }

    @Test
    public void should_add_job_to_wn() throws Exception {
        Mockito.when(jobsRepository.save(okJob)).thenReturn(okJob);
        Mockito.when(jobsRepository.findById(okJob.getId())).thenReturn(okJob);
        Mockito.when(werknemerRepository.findByEmail(okWN.getEmail())).thenReturn(okWN);
        Mockito.when(werknemerRepository.save(okWN)).thenReturn(okWN);

        myService.addJobToWN(okWN.getEmail(), okJob.getId());

         Werknemer wn = myService.findWerknemerByMail(okWN.getEmail());

        assertThat(wn.getCurrentJob()).isNotNull();
    }

    @Test
    public void should_find_roll(){
        Mockito.when(werknemerRepository.findByEmail(okWN.getEmail())).thenReturn(okWN);


        Werknemer wn = werknemerRepository.findByEmail(okWN.getEmail());

        assertThat(wn.getRole()).isEqualTo(okWN.getRole());
    }

    @Test
    public void should_find(){

    }
}
