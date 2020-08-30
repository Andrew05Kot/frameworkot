package com.kot.portfolio.api.dto;

import com.kot.portfolio.api.general.AbstractRequest;
import com.kot.portfolio.api.general.AbstractResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO implements AbstractRequest, AbstractResponse {

	private Long id;
	private String facebookId;
	private String lastName;
	private String firstName;
	private String surname;
	private String phoneNumber;
	private String email;
}
