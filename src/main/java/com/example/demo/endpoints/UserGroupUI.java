package com.example.demo.endpoints;

import com.example.demo.controler.UserGroupControler;
import com.example.demo.endpoints.dto.UserGroupDto;
import com.example.demo.entity.UserGroupEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserGroupUI {

    @Autowired
    UserGroupControler userGroupControler;

    @GetMapping("/getUserGroup")
    List<UserGroupEntity> getUserGroupList(){
        log.debug("log enable");
        return userGroupControler.getAllGroupName();
    }

    @PostMapping("/createGroup")
    String createUserGroup(@RequestBody UserGroupDto userGroupDto){

        userGroupControler.createUserGroup(userGroupDto);

        return "SUCCESS";
    }


}
