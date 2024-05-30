package com.training.numberportabilityportalproject.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.training.numberportabilityportalproject.security.jwt.AuthEntryPointJwt;
import com.training.numberportabilityportalproject.security.jwt.AuthTokenFilter;
import com.training.numberportabilityportalproject.security.service.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public final static String[] PUBLIC_REQUEST_MATCHERS = { "/api/auth/**", "/api-docs/**", "/swagger-ui/**","/v3/api-docs/**" };
	
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.cors(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable)
					.authorizeHttpRequests(req -> req.requestMatchers(PUBLIC_REQUEST_MATCHERS).permitAll()
							.requestMatchers("/api/test/systemadmin").hasRole("SYSTEM_ADMIN")
							.requestMatchers("/api/test/compliance").hasRole("COMPLIANCE_OFFICER")
							.requestMatchers("/api/test/customerservice").hasRole("CUSTOMER_SERVICE")
							.requestMatchers("/api/admin/**").hasRole("SYSTEM_ADMIN")
							.requestMatchers("/api/customerservice/**").hasRole("CUSTOMER_SERVICE")
							.requestMatchers("/api/complianceofficer/**").hasRole("COMPLIANCE_OFFICER"))
					.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.authenticationProvider(authenticationProvider())
					.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
			return http.build();
		}
	

}