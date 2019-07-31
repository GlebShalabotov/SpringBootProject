package be.ucll.herexamen.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public abstract class User {

    @OneToOne(cascade = CascadeType.ALL)
    User user;

    public User(){

    }

}
