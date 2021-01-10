package com.kot.frameworkot.api.mapper;

import com.kot.frameworkot.api.dto.user.UserRequest;
import com.kot.frameworkot.api.dto.user.UserResponse;
import com.kot.frameworkot.dal.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

	public UserRequest convertToUserRequest(UserEntity userEntity) {
		UserRequest user = new UserRequest();
		user.setLastName(userEntity.getLastName());
		user.setFirstName(userEntity.getFirstName());
		user.setSurname(userEntity.getSurname());
		user.setFacebookId(userEntity.getFacebookId());
		user.setPhoneNumber(userEntity.getPhoneNumber());
		user.setEmail(userEntity.getEmail());
		return user;
	}

	public UserResponse convertToUserResponse(UserEntity userEntity) {
		UserResponse user = new UserResponse();
		user.setId(userEntity.getId());
		user.setLastName(userEntity.getLastName());
		user.setFirstName(userEntity.getFirstName());
		user.setSurname(userEntity.getSurname());
		user.setFacebookId(userEntity.getFacebookId());
		user.setPhoneNumber(userEntity.getPhoneNumber());
		user.setEmail(userEntity.getEmail());
		return user;
	}

}
