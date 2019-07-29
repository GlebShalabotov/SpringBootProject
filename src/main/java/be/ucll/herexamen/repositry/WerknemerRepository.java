package be.ucll.herexamen.repositry;

import be.ucll.herexamen.model.Werknemer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WerknemerRepository extends JpaRepository<Werknemer, Integer> {

    Werknemer findByEmail(String email);
}
