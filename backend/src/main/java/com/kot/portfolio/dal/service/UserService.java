package com.kot.portfolio.dal.service;

import com.kot.portfolio.dal.entity.UserEntity;
import com.kot.portfolio.dal.repository.BaseCRUDRepository;
import com.kot.portfolio.dal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<UserEntity>{

	@Autowired
	private UserRepository userRepository;

	@Override
	protected BaseCRUDRepository<UserEntity> getRepository() {
		return userRepository;
	}

	@Override
	public Page<UserEntity> findAll(Pageable pageable){
		return super.findAll(pageable);
	}

	@Override
	public UserEntity create(UserEntity userEntity){
		return super.create(userEntity);
	}

	@Override
	public void update(UserEntity entity) {
		super.update(entity);
	}

	@Override
	public void delete(Long id) {
		super.delete(id);
	}

}
