package com.disney.proy.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.proy.model.Personaje;
import com.disney.proy.repository.PersonajeRepository;
import com.disney.proy.service.PersonajeService;

@Service
public class PersonajeServiceImpl implements PersonajeService {
@Autowired
private PersonajeRepository personajeRepository;
//@Override
////public void get() {
////	personajeRepository.findAllById(null);
////}


}
