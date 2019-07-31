package be.ucll.herexamen.configuration;

import be.ucll.herexamen.CustomAccessDeniedHandler;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) throws Exception{
        this.dataSource = dataSource;
    }
    @Override
    protected void configure(HttpSecurity http ) throws Exception{

        http.authorizeRequests()
                .mvcMatchers("/overzicht", "/h2-console/**").permitAll()
                .mvcMatchers("/overzicht/details*").hasAnyRole("WERKGEVER", "WERKNEMER")
                .mvcMatchers("/toevoegen/*").hasAnyRole("WERKGEVER", "WERKNEMER")
                .mvcMatchers("/toevoegen/add/*").hasRole("WERKNEMER")
                .mvcMatchers("/console/**").permitAll()
               /* .mvcMatchers("/aannemen/**").hasRole("WERKNEMER")
                .mvcMatchers("/aannemen/*").hasRole("WERKNEMER")*/
                .mvcMatchers("/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/overzicht")
                .permitAll()
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler());;
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select email, password, 'true' as enabled  from werknemer where email=? limit 1")
                .authoritiesByUsernameQuery("select email, role from werknemer where email=?");
        // authentication manager config}
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;    }
   /* @Bean
    @Override
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder().username("Elise").password("password").roles("WERKGEVER").build();

        return new InMemoryUserDetailsManager(user);
    }*/
}
