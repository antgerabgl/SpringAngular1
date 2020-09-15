package com.blog.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.app.ws.io.entity.UserEntity;
import com.blog.app.ws.repository.UserRepository;
import com.blog.app.ws.service.UserService;
import com.blog.app.ws.shared.Utils;
import com.blog.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository; 
	
	@Autowired
	Utils utils;
	
	
	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity checkEmailDuplicate = userRepository.findByEmail(user.getEmail());
		
		if(checkEmailDuplicate != null) throw new RuntimeException("EMAIL YA EXISTE ESCRIBA OTRO DISTINTO..."); 

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId = utils.generateUserId(30); 
		userEntity.setUserId(publicUserId);
		
		
		//userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setEncryptedPassword("123");
		
		UserEntity storedUserDetails = userRepository.save(userEntity);

		
		UserDto returnedValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnedValue);
		
		return returnedValue;
	}

//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		UserEntity userEntity = userRepository.findByEmail(email);
//		if(userEntity == null) throw new UsernameNotFoundException(email); 
//		
//		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
//	}

	@Override
	public UserDto getUser(String email) {

		UserEntity userEntity = userRepository.findByEmail(email);

		if (userEntity == null) throw new RuntimeException("EL EMAIL YA EXISTE COLOCA OTRO DISTINTO...");

		String q = userEntity.getEmail();
		String w = userEntity.getUserId();
		
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userId);
		if(userEntity == null) throw new RuntimeException("EL EMAIL YA EXISTE COLOCA OTRO DISTINTO...");
		String q = userEntity.getEmail();
		String w = userEntity.getUserId();
		
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

}
