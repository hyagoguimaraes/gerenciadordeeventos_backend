package org.evento.gerenciadordeeventos.security;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthorizationFilter extends OncePerRequestFilter{
	
	@Override
	protected void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain)
			throws jakarta.servlet.ServletException, java.io.IOException {
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
