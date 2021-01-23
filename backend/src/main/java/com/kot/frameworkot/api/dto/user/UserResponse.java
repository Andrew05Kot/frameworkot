package com.kot.frameworkot.api.dto.user;

import com.kot.frameworkot.api.common.AbstractResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse implements AbstractResponse {

	private String id;
	private String socialId;
	private String lastName;
	private String firstName;
	private String surname;
	private String phoneNumber;
	private String email;

}
