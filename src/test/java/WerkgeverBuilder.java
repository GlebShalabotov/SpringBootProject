import be.ucll.herexamen.model.Werkgever;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public final class WerkgeverBuilder {
    private int id;
    private String password;
    private String email;
    private String role ="ROLE_WERKGEVER";
    private String name;
    private String lastName;
    private String telefoon;
    private String aangemeld;
    private String bedrijf;
    private int score;

    private WerkgeverBuilder() {
    }

    public static WerkgeverBuilder aWerkgever() {
        return new WerkgeverBuilder();
    }

    public static WerkgeverBuilder anOKWerkgever(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String ww = "pw";
        String origenal = encoder.encode(ww);
        return aWerkgever()
                .withAangemeld("20/09/2017")
                .withBedrijf("Ngt")
                .withEmail("Gleb@Shalabotov.be")
                .withId(2)
                .withLastName("Shalabotov")
                .withName("Gleb")
                .withPassword(origenal)
                .withScore(4)
                .withTelefoon("089864184");
    }

    public static WerkgeverBuilder anOtherOKWerkgever(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String ww = "pw";
        String origenal = encoder.encode(ww);
        return aWerkgever()
                .withAangemeld("20/09/2015")
                .withEmail("DIRK@Shalabotov.be")
                .withId(5)
                .withLastName("Shalabotov")
                .withName("DIRK")
                .withPassword(origenal)
                .withScore(2)
                .withTelefoon("089864184");
    }

    public WerkgeverBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public WerkgeverBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public WerkgeverBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public WerkgeverBuilder withRole(String role) {
        this.role = role;
        return this;
    }

    public WerkgeverBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public WerkgeverBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public WerkgeverBuilder withTelefoon(String telefoon) {
        this.telefoon = telefoon;
        return this;
    }

    public WerkgeverBuilder withAangemeld(String aangemeld) {
        this.aangemeld = aangemeld;
        return this;
    }

    public WerkgeverBuilder withBedrijf(String bedrijf) {
        this.bedrijf = bedrijf;
        return this;
    }

    public WerkgeverBuilder withScore(int score) {
        this.score = score;
        return this;
    }

    public Werkgever build() {
        Werkgever werkgever = new Werkgever();
        werkgever.setId(id);
        werkgever.setPassword(password);
        werkgever.setEmail(email);
        werkgever.setRole(role);
        werkgever.setName(name);
        werkgever.setLastName(lastName);
        werkgever.setTelefoon(telefoon);
        werkgever.setAangemeld(aangemeld);
        werkgever.setBedrijf(bedrijf);
        werkgever.setScore(score);
        return werkgever;
    }
}
