package com.blog.app.ws.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.app.ws.io.entity.PersonaEntity;
import com.blog.app.ws.repository.PersonaRepositorio;
import com.blog.app.ws.service.PersonaService;
import com.blog.app.ws.shared.dto.PersonaDTO;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaRepositorio personarepo;
	
	@Override
	public List<PersonaEntity> listar() {
		List<PersonaEntity> t = personarepo.findAll();
		return t;
	}

	@Override
	public PersonaEntity add(PersonaEntity p) {
		System.out.println("MANDANDO PESONA A REPOSITORIO...");
		PersonaEntity pp = personarepo.save(p);
		return pp;
	}
	
	@Override
	public PersonaEntity listarId(int id) {
		System.out.println("REPOSITORIO LISTAR POR ID ...");
//		PersonaEntity t = personarepo.findById(id);
//		PersonaDTO personaDto = new PersonaDTO();
//		
//		personaDto.setId(t.getId());
//		personaDto.setName(t.getName());
//		personaDto.setApellidos(t.getApellidos());
		
		
		return personarepo.findById(id);
	}

	@Override
	public PersonaEntity edit(PersonaEntity p) {
		System.out.println("ACTUALIZANDO PESONA EN REPOSITORIO...");
		PersonaEntity pp = personarepo.save(p);
		return pp;
	}

	@Override
	public PersonaEntity delete(int id) {
		PersonaEntity p = personarepo.findById(id);
		if( p != null) {
		personarepo.delete(p);
		}
		 return p;
	}

	

	

	

}
