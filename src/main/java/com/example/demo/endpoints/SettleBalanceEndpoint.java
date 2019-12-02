package com.example.demo.endpoints;

import com.example.demo.endpoints.dto.SettleBalanceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SettleBalanceEndpoint {

    @PostMapping
    @RequestMapping("/settleAmount")
    Map<HttpStatus, String> settleAmount(SettleBalanceDTO settleBalanceDTO){
        Map<HttpStatus, String> statusMap = new HashMap<>();


        statusMap.put(HttpStatus.OK, "Balance settle");
        return statusMap;

    }
}
