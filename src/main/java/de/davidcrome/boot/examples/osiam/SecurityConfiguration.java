package de.davidcrome.boot.examples.osiam;

import org.osiam.client.OsiamConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private OsiamAuthenticationProvider osiamAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(osiamAuthenticationProvider);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf().disable()
                .exceptionHandling()
                .and()
                .formLogin()
                .permitAll()
                .loginPage("/login")
                .defaultSuccessUrl("/start")
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/my-**").permitAll()
                .antMatchers("/app-name").permitAll()
                .anyRequest().authenticated();
        // @formatter:on
    }

    @Bean
    public OsiamAuthenticationProvider authenticationProvider(OsiamConnector osiamConnector,
                                                              HttpSession httpSession) {
        return new OsiamAuthenticationProvider(osiamConnector, httpSession);
    }

    @Bean
    public OsiamConnector osiamConnector(@Value("${osiam.endpoint}") String endpoint,
                                         @Value("${osiam.client.id}") String clientId,
                                         @Value("${osiam.client.secret}") String clientSecret) {
        return new OsiamConnector.Builder()
                .withEndpoint(endpoint)
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();
    }
}
