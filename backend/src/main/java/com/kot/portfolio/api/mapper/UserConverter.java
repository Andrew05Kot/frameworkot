package com.kot.portfolio.api.mapper;

import com.kot.portfolio.api.dto.UserDTO;
import com.kot.portfolio.dal.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

	public UserDTO convertToUserDTO(UserEntity userEntity) {
		UserDTO user = new UserDTO();
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
