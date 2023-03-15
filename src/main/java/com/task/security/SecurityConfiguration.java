package com.task.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.task.security.jwt.JWTFilter;


@Configuration
public class SecurityConfiguration {

	@Bean
	public JWTFilter authenticationJwtTokenFilter() {
		return new JWTFilter();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.authorizeRequests()	
		.antMatchers(HttpMethod.POST, "/api/register").permitAll()	
		.antMatchers(HttpMethod.POST, "/api/authenticate").permitAll()	
		.antMatchers(HttpMethod.GET, "/api/task/**").permitAll()	
		.antMatchers(HttpMethod.GET, "/api/account").permitAll()	
		.anyRequest().authenticated()
		//.and()
        //.httpBasic()
		;
                
		
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}

	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		final CorsConfiguration config = new CorsConfiguration();

		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
