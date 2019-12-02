package com.example.demo.endpoints;

import com.example.demo.controler.SplitAmountService;
import com.example.demo.endpoints.dto.EnterAmountDTO;
import com.example.demo.endpoints.dto.UserGroupDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController()
@RequestMapping("/api")
public class EnterAmountForSplitController {
    @Autowired
    SplitAmountService splitAmountService;

    @PostMapping("/enterAmount")
    Map<HttpStatus, String> enterAmount(@RequestBody EnterAmountDTO enterAmountDTO){
        Map<HttpStatus, String> statusMap = new HashMap<>();

        log.debug("lenterAmount e dhukse");


        splitAmountService.splitAmount(enterAmountDTO);

        statusMap.put(HttpStatus.OK, "Saved Item Successfully");

        return statusMap;
    }
}
