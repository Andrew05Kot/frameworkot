package com.kot.frameworkot.dal.repository;

import com.kot.frameworkot.dal.entity.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseCRUDRepository<E extends BaseEntity> extends MongoRepository<E, Long>{

}
