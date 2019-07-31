package be.ucll.herexamen.repositry;

import be.ucll.herexamen.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Job, Integer> {

    List<Job> findByWerkgever (String werkgever);
    List<Job> getByWerkgever (String werkgever);
    List<Job> findByJobStatus(String jobStatus);
    Job findById(int id);
}
