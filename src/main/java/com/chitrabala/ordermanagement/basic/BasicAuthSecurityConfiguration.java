package com.chitrabala.ordermanagement.basic;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

	@Configuration
	public class BasicAuthSecurityConfiguration{
	
		@SuppressWarnings("removal")
		@Bean
		SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
			http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
			//http.formLogin(withDefaults());
			http.httpBasic(withDefaults());
			http.sessionManagement(session ->
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
			http.csrf().disable();
			
			return http.build();
		}
		
		@Bean
		public UserDetailsService userDetailsService() {
			var admin = User.withUsername("chitrabala")
					.password("{noop}dummy")
					.roles("admin")
					.build();
			
			return new InMemoryUserDetailsManager(admin);
		}
	}


