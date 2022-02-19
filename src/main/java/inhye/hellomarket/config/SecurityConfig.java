package inhye.hellomarket.config;

import inhye.hellomarket.security.AuthFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@Configuration
@EnableWebSocket
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthFailureHandler authFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/members/new", "/members/failLogin")
                    .permitAll()
                .and()
                    .formLogin()
                    .loginPage("/members/login")
                    .failureHandler(authFailureHandler)
                    .defaultSuccessUrl("/")
                    .usernameParameter("name")
                    .passwordParameter("password");

        http
                .logout()
                .logoutUrl("/members/logout")
                .logoutSuccessUrl("/members/login")
                .invalidateHttpSession(true);
    }
}
