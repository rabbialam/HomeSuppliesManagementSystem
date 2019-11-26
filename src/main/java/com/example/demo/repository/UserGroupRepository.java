package com.example.demo.repository;

import com.example.demo.entity.UserGroupEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserGroupRepository extends CrudRepository<UserGroupEntity, Long> {
    List<UserGroupEntity> findAll();
}
