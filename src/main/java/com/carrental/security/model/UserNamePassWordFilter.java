package com.carrental.security.model;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.carrental.exception.BadRequestException;
import com.carrental.security.dto.LoginRequest;
import com.carrental.security.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class UserNamePassWordFilter extends AbstractAuthenticationProcessingFilter{

	@Autowired
	private CustomerRepository customerRepo;
	private final JwtUtil jwtUtil;
	
	
    public UserNamePassWordFilter(@Lazy AuthenticationManager authenticationManager,JwtUtil jwtUtil) {
        super(new AntPathRequestMatcher("/auth/login", "POST"));
        setAuthenticationManager(authenticationManager);
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException, IOException {

    	 // Use ObjectMapper from Jackson to read JSON body
        ObjectMapper mapper = new ObjectMapper();

        LoginRequest loginRequest = mapper.readValue(request.getInputStream(), LoginRequest.class);

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        username = username.trim();

        // Create an authentication token with extracted credentials
        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(username, password);

        // Let AuthenticationManager authenticate the token
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            jakarta.servlet.FilterChain chain,
                                            Authentication authResult) throws IOException {

    	SecurityContextHolder.getContext().setAuthentication(authResult);

        // Generate JWT
        String username = authResult.getName();
        String token = jwtUtil.generateToken(username,authResult.getAuthorities());

        // Send token to the client (could also use headers)
        response.setContentType("application/json");
        response.getWriter().write("{\"token\": \"" + token + "\"}");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {

        // Return 401 Unauthorized on failed authentication
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Authentication Failed: " + failed.getMessage());
    }
}
