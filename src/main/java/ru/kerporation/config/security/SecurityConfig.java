package ru.kerporation.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.kerporation.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/readme.txt").permitAll()
				.anyRequest().authenticated()
				.and()
//				.formLogin().loginPage("/login").permitAll()
				.formLogin().permitAll()
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();

	}

//	@Bean
//	public PasswordEncoder bcryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(userService);
//				.passwordEncoder(bcryptPasswordEncoder());
	}
}
