package com.kot.portfolio.api.dto.user;

import com.kot.portfolio.api.general.AbstractRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest implements AbstractRequest {

	private String facebookId;
	private String lastName;
	private String firstName;
	private String surname;
	private String phoneNumber;
	private String email;
}
