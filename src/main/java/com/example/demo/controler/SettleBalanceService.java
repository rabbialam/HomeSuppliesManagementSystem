package com.example.demo.controler;

import com.example.demo.endpoints.dto.SettleBalanceDTO;

import java.util.List;

public interface SettleBalanceService {

    List<String> settleBalanceFroGroup(SettleBalanceDTO settleBalanceDTO);
}
