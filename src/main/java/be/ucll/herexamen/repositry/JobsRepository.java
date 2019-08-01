package be.ucll.herexamen.repositry;

import be.ucll.herexamen.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Job, Integer> {

    List<Job> findByJobStatus(String jobStatus);
    Job findById(int id);
    List<Job> findAllByWerkgeverId(int i);

    /*List<Job> findByBeschrijvingRegex(String regex);*/
}
