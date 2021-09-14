package com.disney.proy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.disney.proy.dto.UsuarioDto;
import com.disney.proy.model.AuthenticationRequest;
import com.disney.proy.model.AuthenticationResponse;
import com.disney.proy.model.Usuario;
import com.disney.proy.service.UsuarioService;
import com.disney.proy.service.impl.UsuarioDetalleServiceImpl;
import com.disney.proy.util.JwtUtil;


@Controller
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioDetalleServiceImpl usuarioDetalleServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<?> createAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
				);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		UserDetails usuario = usuarioDetalleServiceImpl.loadUserByUsername(authenticationRequest.getUsername());
		String jwt = jwtUtil.generateToken(usuario);
		return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> createAccount(@RequestBody UsuarioDto usuarioDto){
		Usuario usuario = usuarioService.save(usuarioDto);
		return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
	}
	

}
