package com.kot.portfolio.api.dto.user;

import com.kot.portfolio.api.general.AbstractResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse implements AbstractResponse {

	private Long id;
	private String facebookId;
	private String lastName;
	private String firstName;
	private String surname;
	private String phoneNumber;
	private String email;

}
