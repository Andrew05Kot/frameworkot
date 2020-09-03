package com.kot.portfolio.dal.service;

import com.kot.portfolio.dal.entity.UserEntity;
import com.kot.portfolio.dal.repository.BaseCRUDRepository;
import com.kot.portfolio.dal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
