package com.kot.frameworkot.dal.service;

import com.kot.frameworkot.dal.entity.UserEntity;
import com.kot.frameworkot.dal.repository.BaseCRUDRepository;
import com.kot.frameworkot.dal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends AbstractService<UserEntity>{

	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> findAll(){
		return getRepository().findAll();
	}

	@Override
	protected BaseCRUDRepository<UserEntity> getRepository() {
		return userRepository;
	}
}
