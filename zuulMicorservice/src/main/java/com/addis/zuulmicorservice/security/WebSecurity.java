package com.addis.zuulmicorservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	// SINCE ZUUL IS A GATEWAY AND SERVE AS LOAD-BALANCER FOR A CLIENT REQUEST, WE CAN CONFIGURE SECURITY  HERE
	// HENCE HAS TO EXTENDS WEB-SECURITY-ADAPTER
	// CONFIGURE METHOD GIVE US ACCESS TO HTTP-SECURITY OBJECTS
	
	//TO CONFIGURE HTTP-SECURITY NEED TO ACCESS PROPERTY FILE TO ACCESS THIS WE NEED TO HAVE ENVIRONMENT OBJECTS AUTOWIRED
    
	private final Environment environment;
	
    @Autowired
    public WebSecurity(Environment environment) {
    	this.environment = environment;
    }
	protected void configure(HttpSecurity http)throws Exception {
		
		// CROSS-SIDE-REQUEST-FORGERY IS ENABLED BY DEFAULT IF WEB-SECURITY-CONGURER-ADAPTER IS EXTENDED
		http.csrf().disable();
		
		// PREVENT-DISABLE HEADERS FROM BEING ADDED TO THE RESPONSE
		http.headers().frameOptions().disable();
		
		// ALLOW ACCESS TO USER SERVICE LOGIN END POINTS i.e. [post-method] and ACCESSE URL VIA ENVIRONMET VARIABLES
		http.authorizeRequests()
			.antMatchers(environment.getProperty("api.h2console.url.path")).permitAll() //TO GET ACCESS TO H2-CONSOLE		
			.antMatchers(HttpMethod.POST,environment.getProperty("api.registration.url.path")).permitAll() // TO SIGN UP
			.antMatchers(HttpMethod.POST,environment.getProperty("api.login.url.path")).permitAll()  // TO LOGIN
			.anyRequest().authenticated()//ANY OTHER REQUEST SHOULD BE AUTHENTHICATED.
			.and()
			.addFilter(new AuthorizationFilter(authenticationManager(),environment)); 
		 
		// FOR MULTIPLE INCOIMG REQUEST EACH SESSION COULD CREATE CACHEABLE SECURITY-HEADERS, HENCE EACH REQUESTS
		// DONOT NEED AUTHORIZTION, WE NEED TO DISABLE THIS and MAKE THIS STATELESS.
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	 
	}
}













