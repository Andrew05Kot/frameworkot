package com.kot.frameworkot.dal.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "users")
public class UserEntity implements BaseEntity{

	@Id
	private String id;
	private String facebookId;
	private String lastName;
	private String firstName;
	private String surname;
	private String phoneNumber;
	private String email;
}
