package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Spring_Config {

	
	
	@Bean
	public SecurityFilterChain security(HttpSecurity http) throws Exception {
		http
		.csrf(fg->fg.disable())
		.authorizeHttpRequests(auth->auth.requestMatchers("/").permitAll().anyRequest().authenticated())
		.formLogin(login->login.loginPage("/login")
//				.loginProcessingUrl("/profile")
				.permitAll())
		.logout(log->log.logoutSuccessUrl("/"));
		return http.build();
	}
	
	@Bean
	public UserDetailsService service() {
		
		UserDetails user1=User.builder()
				.username("user1")
				.password(encoder().encode("user1"))
				.build();
		
		UserDetails user2=User.builder()
				.username("user2")
				.password(encoder().encode("user2"))
				.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	
	
}
