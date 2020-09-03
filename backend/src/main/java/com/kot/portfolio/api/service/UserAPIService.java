package com.kot.portfolio.api.service;

import com.kot.portfolio.api.dto.user.UserRequest;
import com.kot.portfolio.api.dto.user.UserResponse;
import com.kot.portfolio.api.mapper.UserConverter;
import com.kot.portfolio.dal.entity.UserEntity;
import com.kot.portfolio.dal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAPIService extends AbstractAPIService<UserEntity, UserRequest, UserResponse, UserService>{

	@Autowired
	private UserConverter userConverter;

	@Override
	protected UserEntity getNewEntity(UserRequest request) {
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
	protected void copyProperties(UserRequest request, UserEntity entity) {
		request.setLastName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		request.setSurname(entity.getSurname());
		request.setFacebookId(entity.getFacebookId());
		request.setPhoneNumber(entity.getPhoneNumber());
		request.setEmail(entity.getEmail());
	}

	@Override
	protected UserResponse convertToResponseBean(UserEntity entity) {
		return userConverter.convertToUserResponse(entity);
	}
}
