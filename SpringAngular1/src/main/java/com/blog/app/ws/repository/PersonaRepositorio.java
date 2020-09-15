package com.blog.app.ws.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.blog.app.ws.io.entity.PersonaEntity;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@Repository
public interface PersonaRepositorio extends  CrudRepository<PersonaEntity, Integer> {			//Repository<PersonasEntity,Integer> {
	

	List<PersonaEntity> findAll();
	PersonaEntity findById(int id);
	
	
}
