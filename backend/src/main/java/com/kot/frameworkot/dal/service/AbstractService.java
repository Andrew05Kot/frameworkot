package com.kot.frameworkot.dal.service;

import com.kot.frameworkot.dal.entity.BaseEntity;
import com.kot.frameworkot.dal.repository.BaseCRUDRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class AbstractService<Entity extends BaseEntity> {

	protected abstract BaseCRUDRepository<Entity> getRepository();

	public Entity create(Entity entity) {
		return getRepository().save(entity);
	}

	public void update(Entity entity) {
		getRepository().save(entity);
	}

	public void delete(Long id) {
		getRepository().deleteById(id);
	}

	public Page<Entity> findAll(Pageable paging) {
		return getRepository().findAll(paging);
	}

	public Entity findById(Long id) {
		return getRepository().findById(id).orElse(null);
	}

}