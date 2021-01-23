package com.kot.frameworkot.dal.service;

import lombok.extern.slf4j.Slf4j;
import com.kot.frameworkot.dal.entity.BaseEntity;
import com.kot.frameworkot.dal.repository.BaseCRUDRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
public abstract class AbstractService<Entity extends BaseEntity> {

	protected abstract BaseCRUDRepository<Entity> getRepository();

	public Entity create(Entity entity) {
		Entity savedEntity = getRepository().save(entity);
		log.info("IN create - " + savedEntity.getClass().getName() + " " + savedEntity + " was saved");
		return savedEntity;
	}

	public void update(Entity entity) {
		getRepository().save(entity);
		log.info("IN update - " + entity.getClass().getName() + " successfully updated");
	}

	public void delete(Long id) {
		getRepository().deleteById(id);
		log.info("IN delete - entity with id " + id + " successfully deleted");
	}

	public Page<Entity> findAll(Pageable paging) {
		log.info("IN findAll");
		return getRepository().findAll(paging);
	}

	public Entity findById(Long id) {
		Entity entity = getRepository().findById(id).orElse(null);
		if (entity == null) {
			log.info("IN findById - entity with id: " + id + " is not found");
			return null;
		}
		log.info("IN findById - entity with id " + id + " is - " + entity);
		return entity;
	}

}