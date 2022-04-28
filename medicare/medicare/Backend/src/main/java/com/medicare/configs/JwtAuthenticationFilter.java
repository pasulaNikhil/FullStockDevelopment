package com.medicare.configs;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil JwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
      
        final String requestHeaderToken = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        
        if(requestHeaderToken!=null && requestHeaderToken.startsWith("Bearer ")){
            try {
                jwtToken = requestHeaderToken.substring(7);
                username = JwtUtil.extractUsername(jwtToken);
            }catch(ExpiredJwtException e){
             e.printStackTrace();
             System.out.println("Token expired");
            } 
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error");
            }

        }else{
            System.out.println("Invalid Token");
        }

        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
           final UserDetails userDetails= this.userDetailsService.loadUserByUsername(username);
           if(this.JwtUtil.validateToken(jwtToken, userDetails)){
               UsernamePasswordAuthenticationToken authentication =
                  new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
               authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

               SecurityContextHolder.getContext().setAuthentication(authentication);;
           }
        }else{
            System.out.println("Token is not valid");
        }

        filterChain.doFilter(request, response);
        
    }
    
}