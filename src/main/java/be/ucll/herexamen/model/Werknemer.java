package be.ucll.herexamen.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Werknemer {

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
    public String cv;

    public Date aangemeld;

}
