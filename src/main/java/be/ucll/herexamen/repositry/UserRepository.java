package be.ucll.herexamen.repositry;

import be.ucll.herexamen.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends UserBaseRepository<User>{
}
