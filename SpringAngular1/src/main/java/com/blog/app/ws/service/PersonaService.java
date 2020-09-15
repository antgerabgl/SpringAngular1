package com.blog.app.ws.service;

import java.util.List;
import com.blog.app.ws.io.entity.PersonaEntity;
import com.blog.app.ws.shared.dto.PersonaDTO;

public interface PersonaService {
	
	List<PersonaEntity> listar();
	PersonaEntity listarId(int id);
	PersonaEntity add(PersonaEntity p);
	PersonaEntity edit(PersonaEntity p);
	PersonaEntity delete(int id);
	
}
