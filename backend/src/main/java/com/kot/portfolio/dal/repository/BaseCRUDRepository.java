package com.kot.portfolio.dal.repository;

import com.kot.portfolio.dal.entity.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseCRUDRepository<E extends BaseEntity> extends MongoRepository<E, Long>{

}
