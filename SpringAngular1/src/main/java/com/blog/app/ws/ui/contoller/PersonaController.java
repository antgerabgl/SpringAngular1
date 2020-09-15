package com.blog.app.ws.ui.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.app.ws.io.entity.PersonaEntity;
import com.blog.app.ws.service.PersonaService;
import com.blog.app.ws.service.UserService;
import com.blog.app.ws.shared.dto.PersonaDTO;


@CrossOrigin  //(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class PersonaController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PersonaService personaService;

	@GetMapping("/personas") 
	public List<PersonaEntity> listar(){
		System.out.println("MANDANDO PESONA A SERVICE LISTAR...");
		List<PersonaEntity> r = personaService.listar();
		return r;
	}
	
	
	@PostMapping("/personas") 
	public PersonaEntity agregar(@RequestBody PersonaEntity p) {
		System.out.println("MANDANDO PESONA A SERVICE AGREGAR ADD...");
		PersonaEntity per =personaService.add(p);
		return per;
	}
	
	
	@GetMapping(path = "/personas/{id}")
	public PersonaEntity listarId(@PathVariable ("id") int id) {
		System.out.println("LISTAR POR ID...");
		return personaService.listarId(id);
	}

	
	@PutMapping(path = "/personas/{id}")
	public PersonaEntity editar(@RequestBody PersonaEntity p, @PathVariable("id") int id) {
		System.out.println("EDITAR POR ID...");
		p.setId(id);
		return personaService.edit(p);
	}
	
	@DeleteMapping(path = {"/personas/{id}"})
	public PersonaEntity delete(@PathVariable("id") int id) {
		return personaService.delete(id);
	}
	
	
//	@PostMapping
//	public UserRest createUser(@RequestBody UserDatailsRequestModel userDetails) {
//
//		UserRest returnValue = new UserRest();
//
//		UserDto userDto = new UserDto();
//		BeanUtils.copyProperties(userDetails, userDto);
//
//		UserDto createdUser = userService.createUser(userDto);
//		BeanUtils.copyProperties(createdUser, returnValue);
//
//		return returnValue;
//	}

	
}// CLASE
