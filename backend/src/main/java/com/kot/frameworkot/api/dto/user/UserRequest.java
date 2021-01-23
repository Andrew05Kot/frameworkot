package com.kot.frameworkot.api.dto.user;

import com.kot.frameworkot.api.common.AbstractRequest;
import com.kot.frameworkot.dal.entity.user.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest implements AbstractRequest {

	private String socialId;
	private String firstName;
	private String lastName;
	private String surname;
	private String phoneNumber;
	private String email;
	private UserRole role;
}
