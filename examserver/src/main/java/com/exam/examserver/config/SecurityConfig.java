package com.exam.examserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity.ExceptionHandlingSpec;
import org.springframework.security.config.web.servlet.ExceptionHandlingDsl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.server.handler.ExceptionHandlingWebHandler;

import com.exam.examserver.service.UserDetailsServiceImpl;

import ch.qos.logback.core.net.SocketConnector.ExceptionHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
	private UserDetailsServiceImpl userdetservimpl;
    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
    	// TODO Auto-generated method stub
    	return super.authenticationManagerBean();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
    	
    }
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(this.userdetservimpl).passwordEncoder(passwordEncoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf()
		    .disable()
		    .cors()
		    .disable()
		    .authorizeRequests()
		    .antMatchers("/generate-token","/user/create").permitAll()
		    .antMatchers(HttpMethod.OPTIONS).permitAll()
		    .anyRequest().authenticated()
		    .and()
		    .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
		    .and()
		    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
		    
		    
	}
}
