package com.kot.portfolio.api.controller;

import com.kot.portfolio.api.dto.UserDTO;
import com.kot.portfolio.api.service.UserAPIService;
import com.kot.portfolio.dal.entity.UserEntity;
import com.kot.portfolio.dal.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController extends AbstractController<UserEntity, UserDTO, UserDTO, UserService, UserAPIService> {

	@Override
	public UserDTO create(@RequestBody UserDTO request) {
		return super.create(request);
	}

	@Override
	public void delete(@PathVariable Long id) {
		throw new UnsupportedOperationException();
	}

}
