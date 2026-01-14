package org.evento.gerenciadordeeventos.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	public JwtAuthenticationFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws jakarta.servlet.ServletException, java.io.IOException {

		String header = request.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer ")) {
			String token = header.substring(7);
			try {
				String email = jwtUtil.extrairEmail(token);

				if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					var authority = new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_USER");

					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email,
							null, java.util.Collections.singletonList(authority));

					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			} catch (Exception e) {
				SecurityContextHolder.clearContext();
			}
		}

		filterChain.doFilter(request, response);
	}
}
