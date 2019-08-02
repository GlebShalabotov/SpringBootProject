import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.model.MyService;
import be.ucll.herexamen.model.Werkgever;
import be.ucll.herexamen.repositry.JobsRepository;
import be.ucll.herexamen.repositry.UserRepository;
import be.ucll.herexamen.repositry.WerkgeverRepository;
import be.ucll.herexamen.repositry.WerknemerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


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
    private JobsRepository jobsRepository;

    @MockBean
    private WerknemerRepository werknemerRepository;

    @MockBean
    private WerkgeverRepository werkgeverRepository;

    @MockBean
    private UserRepository userRepository;

    private Job okJob, nOKjob, anotherOKJob, maybeOKJob;
    private List<Job> jobs,beschikbareJobs,glebsJobs;

    @Before
    public void setUp() {
        okJob = JobBuilder.anOKJob().build();
        nOKjob = JobBuilder.nOKJob().build();
        anotherOKJob = JobBuilder.anOtherOKJob().build();
        jobs = new ArrayList<Job>();
        jobs.add(okJob);
        jobs.add(nOKjob);
        jobs.add(anotherOKJob);
        beschikbareJobs = new ArrayList<Job>();
        glebsJobs = new ArrayList<Job>();

        for(Job j:jobs){
            if(j.getJobStatus() != null){
                if(j.getJobStatus().equals("beschikbaar")) beschikbareJobs.add(j);
            }
            if(j.getWerkgever().getId()== 2) glebsJobs.add(j);
        }


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
}
