package com.kot.frameworkot.dal.service.user;

import com.kot.frameworkot.dal.entity.user.UserEntity;
import com.kot.frameworkot.dal.repository.BaseCRUDRepository;
import com.kot.frameworkot.dal.repository.user.UserRepository;
import com.kot.frameworkot.dal.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService extends AbstractService<UserEntity> {

	@Autowired
	private UserRepository repository;

	public List<UserEntity> findAll(){
		return getRepository().findAll();
	}

	public UserEntity getUserBySocialId(String socialId) {
		UserEntity entity = repository.findBySocialId(socialId).orElse(null);
		if (entity == null) {
			log.info("User wish socialId - " + socialId + " was not found");
			return null;
		}
		log.info("User wish socialId - " + socialId + " is - " + entity);
		return entity;
	}

	@Override
	protected BaseCRUDRepository<UserEntity> getRepository() {
		return repository;
	}
}
