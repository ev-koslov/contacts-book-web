package ev.koslov.config;

import ev.koslov.authentication.AccountsDetailsManager;
import ev.koslov.web.components.NotAuthenticatedEntryPoint;
import ev.koslov.web.components.PageDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountsDetailsManager accountsDetailsManager;
    @Autowired
    private NotAuthenticatedEntryPoint notAuthenticatedEntryPoint;
    @Autowired
    private PageDeniedHandler pageDeniedHandler;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/static/**", "/webjars/**").permitAll()
                .antMatchers("/login", "/register").anonymous()
                .anyRequest().authenticated()

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(notAuthenticatedEntryPoint)
                .accessDeniedHandler(pageDeniedHandler)

                .and()
                .logout().permitAll()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)

                .and()
                .userDetailsService(accountsDetailsManager)
                .csrf().disable();
    }
}