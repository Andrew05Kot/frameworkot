package com.kot.frameworkot.dal.repository;

import com.kot.frameworkot.dal.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseCRUDRepository<UserEntity>{}

