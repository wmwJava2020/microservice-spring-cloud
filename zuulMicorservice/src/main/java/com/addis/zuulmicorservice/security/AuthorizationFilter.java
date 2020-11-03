package com.addis.zuulmicorservice.security;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter{

	Environment environment;
	
	public AuthorizationFilter(AuthenticationManager authManager,Environment  environment) {
		super(authManager);
		this.environment = environment;
	}
	
	protected void doFilterInternal(HttpServletRequest req ,HttpServletResponse res ,FilterChain chain) throws IOException, ServletException {
		
		//READING THE NAME OF AUTHORIZTION HEADER FROM REQUEST OBJECT
		String authorizationHeader = req.getHeader(environment.getProperty("authorization.token.header.name"));
		 
		// WHEN AUTHORIZTION TOKEN IS INCULDED IN AUTHORIZTION HEADER IT WILL HAVE A PREFIX CALLED [** BEARER **]
		if(authorizationHeader == null || !authorizationHeader.startsWith(environment.getProperty("authorization.token.header.prefix")))
        {
		// IF THE ABOVE STATMENT IS NULL THEN WE CAN INVOKE THE SECOND FILTER IN A CHAIN-OF-FILTERING[ DOFILTER ]
		// doFilter()--> Causes the next filter in the chain to be invoked, or if the calling filter is the 
		// last filter in the chain, causes the resource at the end ofthe chain to be invoked.
		chain.doFilter(req, res);
		return;
		}
		 
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res); 
	} 
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) {
		
		//READING HEADER PREFIX FROM HTTP OBJECT AND ASSIGN IT BACK TO AUTHORIZTIONHEADER
		String authoriaztionHeader = req.getHeader(environment.getProperty("authorization.token.header.prefix"));
		
		if(authoriaztionHeader == null) {
			return null;
		}
		
		// REPLACE HEADAER PREFIX [bearer] WITH EMPTY i.e. REMOVE THE PERFIX BEARER FROM TOKEN AND GET ONLY TOKEN
		String token = authoriaztionHeader.replace(environment.getProperty("authorization.token.header.prefix"), "");
		
		// INVOKE JWTS PARSER METHOD TO PARSE USERID EMBDED INSIDE THE TOKEN
		String userId = Jwts.parser()  
				.setSigningKey(environment.getProperty("token.secret")) // SET TOKEN READ FROM A FILE
				.parseClaimsJwt(token)  // PASS THE TOKEN TO BE PARSED AS AN ARGUMENT
				.getBody()  // GET BODY OF A TOKEN
				.getSubject();  //--> IS PUBLIC USERID
		
		if(userId == null) {
			return null;
		} 
		//ELSE                                     
		return new UsernamePasswordAuthenticationToken(userId, null,new ArrayList<>());
		 
		
		
	}

}
  