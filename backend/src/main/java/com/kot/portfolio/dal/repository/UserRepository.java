package com.kot.portfolio.dal.repository;

import com.kot.portfolio.dal.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseCRUDRepository<UserEntity>{}

