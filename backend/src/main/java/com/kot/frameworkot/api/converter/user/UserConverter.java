package com.kot.frameworkot.api.converter.user;

import com.kot.frameworkot.api.dto.user.UserRequest;
import com.kot.frameworkot.api.dto.user.UserResponse;
import com.kot.frameworkot.dal.entity.user.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

	public UserRequest convertToUserRequest(UserEntity userEntity) {
		UserRequest user = new UserRequest();
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setSurname(userEntity.getSurname());
		user.setSocialId(userEntity.getSocialId());
		user.setPhoneNumber(userEntity.getPhoneNumber());
		user.setEmail(userEntity.getEmail());
		return user;
	}

	public UserResponse convertToUserResponse(UserEntity userEntity) {
		UserResponse user = new UserResponse();
		user.setId(userEntity.getId());
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setSurname(userEntity.getSurname());
		user.setSocialId(userEntity.getSocialId());
		user.setPhoneNumber(userEntity.getPhoneNumber());
		user.setEmail(userEntity.getEmail());
		return user;
	}

}
