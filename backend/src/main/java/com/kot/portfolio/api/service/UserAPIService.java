package com.kot.portfolio.api.service;

import com.kot.portfolio.api.dto.UserDTO;
import com.kot.portfolio.api.mapper.UserConverter;
import com.kot.portfolio.dal.entity.UserEntity;
import com.kot.portfolio.dal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAPIService extends AbstractAPIService<UserEntity, UserDTO, UserDTO, UserService>{

	@Autowired
	private UserConverter userConverter;

	@Override
	protected UserEntity getNewEntity(UserDTO request) {
		UserEntity userEntity = new UserEntity();
		userEntity.setLastName(request.getFirstName());
		userEntity.setLastName(request.getLastName());
		userEntity.setSurname(request.getSurname());
		userEntity.setFacebookId(request.getFacebookId());
		userEntity.setPhoneNumber(request.getPhoneNumber());
		userEntity.setEmail(request.getEmail());
		return  userEntity;
	}

	@Override
	protected void copyProperties(UserDTO request, UserEntity entity) {
		request.setLastName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		request.setSurname(entity.getSurname());
		request.setFacebookId(entity.getFacebookId());
		request.setPhoneNumber(entity.getPhoneNumber());
		request.setEmail(entity.getEmail());
	}

	@Override
	protected UserDTO convertToResponseBean(UserEntity entity) {
		return userConverter.convertToUserDTO(entity);
	}
}
