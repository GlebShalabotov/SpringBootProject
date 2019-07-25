package be.ucll.herexamen.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Werkgever {

    @NotNull
    @NotEmpty
    public String name;

    @NotNull
    @NotEmpty
    public String lastName;

    @NotNull
    @NotEmpty
    public String email;

    @NotNull
    @NotEmpty
    public String telefoon;

    @NotNull
    @NotEmpty
    public Date aangemeld;

    @NotNull
    @NotEmpty
    public int score;


    public Werkgever(String name, String lastName, String email, String telefoon){
        setName(name);
        setLastName(lastName);
        setTelefoon(telefoon);
        setEmail(email);
        setAangemeld(new Date());


    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public Date getAangemeld() {
        return aangemeld;
    }

    public void setAangemeld(Date aangemeld) {
        this.aangemeld = aangemeld;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
