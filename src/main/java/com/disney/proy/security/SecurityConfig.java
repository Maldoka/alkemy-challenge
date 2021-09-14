package com.disney.proy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.disney.proy.filter.JwtRequestFilter;
import com.disney.proy.service.impl.UsuarioDetalleServiceImpl;


	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private UsuarioDetalleServiceImpl usuarioDetalleServiceImpl;
		
		@Autowired 
		private JwtRequestFilter jwtRequestFilter;
			
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			return NoOpPasswordEncoder.getInstance();
		}
	
		@Override
		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception{
			return super.authenticationManager();
		}
		
		 @Override
	     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	         auth.userDetailsService(usuarioDetalleServiceImpl).passwordEncoder(this.passwordEncoder());
	     }
		 
		 @Override
		    public void configure(HttpSecurity http) throws Exception {
			 http.csrf().disable().authorizeRequests()
		            .antMatchers("/auth/**").permitAll()
		            .anyRequest().authenticated()
		           .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		        
		 }
		 
	
	

}
