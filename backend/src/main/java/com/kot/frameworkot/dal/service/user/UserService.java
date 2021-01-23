package com.kot.frameworkot.dal.service.user;

import com.kot.frameworkot.dal.entity.user.UserEntity;
import com.kot.frameworkot.dal.repository.BaseCRUDRepository;
import com.kot.frameworkot.dal.repository.user.UserRepository;
import com.kot.frameworkot.dal.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends AbstractService<UserEntity> {

	@Autowired
	private UserRepository repository;

	public List<UserEntity> findAll(){
		return getRepository().findAll();
	}

	public UserEntity getUserBySocialId(String socialId) {
		return repository.findBySocialId(socialId).orElse(null);
	}

	@Override
	protected BaseCRUDRepository<UserEntity> getRepository() {
		return repository;
	}
}
