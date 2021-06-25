package upn.solweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration 
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("admin").password("{noop}password")
          .authorities("ADMIN");
    }
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**").antMatchers("/images/**");
    }
	
	@Override
	protected void configure(HttpSecurity http) 
		throws Exception {
			http
				.csrf().disable()
				.authorizeRequests()
					.antMatchers("/")
					.permitAll()
					.and()
				.authorizeRequests()
					.antMatchers("/citas/registrar/**")
					.permitAll()
					.and()
				.authorizeRequests()
					.antMatchers("/citas/detalle/**")
					.permitAll()
					.and()
				.authorizeRequests()
					.anyRequest()
					.authenticated()
				.and()
					.httpBasic();
		}
}
