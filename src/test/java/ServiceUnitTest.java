import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.model.MyService;
import be.ucll.herexamen.model.Werkgever;
import be.ucll.herexamen.repositry.JobsRepository;
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

    private Job okJob, nOKjob, maybeOKJob;
    private List<Job> jobs;

    @Before
    public void setUp() {
        okJob = JobBuilder.anOKJob().build();
        nOKjob = JobBuilder.nOKJob().build();
        jobs = new ArrayList<Job>();
        jobs.add(okJob);
        jobs.add(nOKjob);

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


}
