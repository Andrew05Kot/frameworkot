package com.kot.frameworkot.api.controller;

import com.kot.frameworkot.api.dto.user.UserRequest;
import com.kot.frameworkot.api.dto.user.UserResponse;
import com.kot.frameworkot.api.service.UserAPIService;
import com.kot.frameworkot.dal.entity.UserEntity;
import com.kot.frameworkot.dal.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController extends AbstractController<UserEntity, UserRequest, UserResponse, UserService, UserAPIService> {

	@Override
	public void delete(@PathVariable Long id) {
		throw new UnsupportedOperationException();
	}

}
