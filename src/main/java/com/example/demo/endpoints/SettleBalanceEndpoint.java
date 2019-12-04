package com.example.demo.endpoints;

import com.example.demo.controler.SettleBalanceService;
import com.example.demo.endpoints.dto.SettleBalanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SettleBalanceEndpoint {

    @Autowired
    SettleBalanceService settleBalanceService;

    @PostMapping
    @RequestMapping("/settleAmount")
    Map<HttpStatus, List<String>> settleAmount(@RequestBody SettleBalanceDTO settleBalanceDTO){
        Map<HttpStatus, List<String>> statusMap = new HashMap<>();


        List<String> settleTransactions = new ArrayList<>();
        settleTransactions = settleBalanceService.settleBalanceFroGroup(settleBalanceDTO);
        statusMap.put(HttpStatus.OK, settleTransactions);
        return statusMap;

    }
}
