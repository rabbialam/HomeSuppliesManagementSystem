package com.example.demo.repository;

import com.example.demo.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserGroupRepository extends JpaRepository<UserGroupEntity, Long> {
    List<UserGroupEntity> findAll();
}
