package com.example.demo.controler;

import com.example.demo.endpoints.dto.UserGroupDto;
import com.example.demo.entity.UserGroupEntity;

import java.util.List;

public interface UserGroupControler {
    List<UserGroupEntity> getAllGroupName();

    void createUserGroup(UserGroupDto userGroupDto);
}
