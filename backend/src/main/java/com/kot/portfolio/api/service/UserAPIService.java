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
	public UserDTO create(UserDTO request) {
		return super.create(request);
	}
	@Override
	protected UserEntity getNewEntity(UserDTO request) {
		return null;
	}

	@Override
	protected void copyProperties(UserDTO request, UserEntity entity) {
		userConverter.convertToUserDTO(entity);
	}

	@Override
	protected UserDTO convertToResponseBean(UserEntity entity) {
		return null;
	}

}
