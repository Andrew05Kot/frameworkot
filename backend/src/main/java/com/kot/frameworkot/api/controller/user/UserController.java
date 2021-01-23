package com.kot.frameworkot.api.controller.user;

import javax.validation.Valid;
import com.kot.frameworkot.api.common.ServiceAPIUrl;
import com.kot.frameworkot.api.controller.AbstractController;
import com.kot.frameworkot.api.dto.user.UserRequest;
import com.kot.frameworkot.api.dto.user.UserResponse;
import com.kot.frameworkot.api.service.user.UserAPIService;
import com.kot.frameworkot.dal.entity.user.UserEntity;
import com.kot.frameworkot.dal.service.user.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = UserController.BASE_URL)
public class UserController extends AbstractController<UserEntity, UserRequest, UserResponse, UserService, UserAPIService> {

	public static final String BASE_URL = ServiceAPIUrl.V1_PATH + "/user";

	@Override
	@ApiOperation( value = "Unsupported operation", hidden = true )
	public UserResponse create( @RequestBody @Valid UserRequest request ) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(@PathVariable Long id) {
		throw new UnsupportedOperationException();
	}

}
