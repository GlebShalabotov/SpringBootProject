package be.ucll.herexamen.repositry;

import be.ucll.herexamen.model.Job;
import be.ucll.herexamen.model.Werkgever;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WerkgeverRepository extends JpaRepository<Werkgever, Integer> {

    public Werkgever findByName(String name);
    public Werkgever findByEmail(String email);


}
