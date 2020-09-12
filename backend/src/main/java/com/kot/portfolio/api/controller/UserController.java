package com.kot.portfolio.api.controller;

import com.kot.portfolio.api.dto.user.UserRequest;
import com.kot.portfolio.api.dto.user.UserResponse;
import com.kot.portfolio.api.service.UserAPIService;
import com.kot.portfolio.dal.entity.UserEntity;
import com.kot.portfolio.dal.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
