package be.ucll.herexamen.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Autowired
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) throws Exception{
        this.dataSource = dataSource;
    }
    @Override
    protected void configure(HttpSecurity http ) throws Exception{

        http.authorizeRequests()
                .mvcMatchers("/overzicht", "/", "/index", "/login","/css/bootstrap.css","/css/eigen.css", "/css/reset.css").permitAll()
                .mvcMatchers("/overzicht/details*","/h2-console/*", "/h2-console/**", "h2-console/***", "/profiel").hasAnyRole("WERKGEVER", "WERKNEMER")
                .mvcMatchers("/toevoegen", "toevegen/*").hasRole("WERKGEVER")
                .mvcMatchers("/toevoegen/add","/toevoegen/add/*","/toevoegen/add/**", "/toevoegen/add/***").hasRole("WERKGEVER")
                .mvcMatchers(HttpMethod.POST, "/toevoegen/add").hasRole("WERKGEVER")
                .mvcMatchers("/aannemen", "/aannemen/*" ,"/aannemen/**", "/aannemen/***", "/aannemen/beschrijving").hasRole("WERKNEMER")
                .mvcMatchers(HttpMethod.POST, "/aannemen/beschrijving").hasRole("WERKNEMER")
                .mvcMatchers("/werkgever/*", "/werknemer/*", "/werkgever/**", "/werknemer/**", "/users").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
                .defaultSuccessUrl("/profiel")
                .and()
                .logout()
                .logoutSuccessUrl("/overzicht")
                .permitAll()
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling().accessDeniedPage("/accesDenied");
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select email, password, 'true' as enabled  from user where email=? limit 1")
                .authoritiesByUsernameQuery("select email, role from user where email=?");
        // authentication manager config}
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;    }

}
