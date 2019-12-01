package com.example.demo.controler;

import com.example.demo.endpoints.dto.UserGroupDto;
import com.example.demo.entity.UserGroupEntity;
import com.example.demo.repository.UserGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class UserGroupControlerImpl implements UserGroupControler{

//	Class log;
	
    @Autowired
    private UserGroupRepository userRepository;


    @Override
    public List<UserGroupEntity> getAllGroupName() {
        return userRepository.findAll();
    }

    @Override
    public void createUserGroup(UserGroupDto userGroupDto) {

        UserGroupEntity userGroupEntity = new UserGroupEntity();

        userGroupEntity.setGroupName(userGroupDto.getGroupName());

        userRepository.save(userGroupEntity);
        
		//log.debug("group named {} is created",userGroupDto.getGroupName());

    }
}
