package com.carrental.security.model;


import java.io.IOException;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class OtpFilter extends AbstractAuthenticationProcessingFilter {

    public OtpFilter(@Lazy AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher("/otp", "POST"));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException, IOException {

        // Extract OTP and username (or user ID) from request parameters
        String otp = request.getParameter("otp");
        String username = request.getParameter("username"); // or from session/context

        if (otp == null || username == null) {
            throw new IllegalArgumentException("OTP and username must be provided");
        }

        // Create a custom OTP Authentication token (you need to implement this)
        OtpAuthenticationToken otpAuthToken = new OtpAuthenticationToken(username, otp);

        // Delegate to AuthenticationManager for authentication
        return this.getAuthenticationManager().authenticate(otpAuthToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            jakarta.servlet.FilterChain chain,
                                            Authentication authResult) throws IOException {

        // Set authentication in SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authResult);

        // Continue the filter chain after successful OTP verification
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("OTP Authentication Failed: " + failed.getMessage());
    }
}
