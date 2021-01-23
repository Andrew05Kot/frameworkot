package com.kot.frameworkot.dal.repository.user;

import java.util.Optional;
import com.kot.frameworkot.dal.entity.user.UserEntity;
import com.kot.frameworkot.dal.repository.BaseCRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseCRUDRepository<UserEntity> {
    Optional<UserEntity> findBySocialId(String socialId); //TODO
}

