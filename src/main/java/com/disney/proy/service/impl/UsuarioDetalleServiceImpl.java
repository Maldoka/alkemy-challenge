package com.disney.proy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.disney.proy.model.Usuario;
import com.disney.proy.repository.UsuarioRepository;

@Service
public class UsuarioDetalleServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		System.out.println("Usuario elegido: " + username);
		Usuario usuario= usuarioRepository.findByUsername(username); ///ojo aca con NOMBRE
		UserBuilder userBuilder=null;
		if(usuario != null) {
			userBuilder = User.withUsername(username);
			userBuilder.disabled(false);
			userBuilder.password(usuario.getClave());
			userBuilder.authorities(new SimpleGrantedAuthority("ROL_USER"));
		}
		else {
			throw new UsernameNotFoundException("Usuario no registrado");
		}
		
		return userBuilder.build();
		
	}

}
