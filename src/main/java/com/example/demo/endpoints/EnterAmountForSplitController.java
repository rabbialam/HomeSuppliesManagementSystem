package com.example.demo.endpoints;

import com.example.demo.controler.SplitAmountService;
import com.example.demo.endpoints.dto.EnterAmountDTO;
import com.example.demo.endpoints.dto.SettleBalanceDTO;
import com.example.demo.endpoints.dto.TransactionDTo;
import com.example.demo.endpoints.dto.UserGroupDto;
import com.example.demo.entity.TransactionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

        //log.debug("lenterAmount e dhukse");
        splitAmountService.splitAmount(enterAmountDTO);

        statusMap.put(HttpStatus.OK, "Saved Item Successfully");

        return statusMap;
    }

    @GetMapping("/getUnsettledTransactions/{groupId}")
    List<TransactionDTo> getUnsettledTransactions(@PathVariable("groupId") Long groupId){
           return splitAmountService.getUnsettledTransactions(groupId);
    }
}
