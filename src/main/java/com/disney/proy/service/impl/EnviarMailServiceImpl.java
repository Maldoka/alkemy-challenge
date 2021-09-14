package com.disney.proy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.disney.proy.model.Usuario;
import com.disney.proy.service.EnviarMailService;


@Service
public class EnviarMailServiceImpl implements EnviarMailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Override
	public void enviarMail(Usuario usuario) {
		SimpleMailMessage mailMessage =  new SimpleMailMessage();
		mailMessage.setTo(usuario.getCorreo());
		mailMessage.setSubject("Bienvenido");
		mailMessage.setText("Su cuenta ha sido creada con exito");
		mailSender.send(mailMessage);
	}

}
