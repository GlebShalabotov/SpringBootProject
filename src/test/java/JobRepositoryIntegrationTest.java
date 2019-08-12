import be.ucll.herexamen.Application;
import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.repositry.JobRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureMockMvc(secure = false)

@RunWith(SpringRunner.class)

@DataJpaTest
@SpringBootTest(classes = Application.class)
public class JobRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private JobRepository jobRepository;

    Job okJob, alsookjob;


    @Test
    public void should_find_all_WeekMenus(){
        okJob = JobBuilder.anOKJob().build();
        entityManager.merge(okJob);
        entityManager.flush();

        alsookjob =JobBuilder.anOtherOKJob().build();
        entityManager.merge(alsookjob);
        entityManager.flush();

        List<Job> jobs = jobRepository.findAll();

        assertThat(jobs.size()).isEqualTo(5);
        assertThat(jobs).contains(okJob);
        assertThat(jobs).contains(alsookjob);
    }
}
