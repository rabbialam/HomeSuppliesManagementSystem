package com.example.demo.controler;

import com.example.demo.endpoints.dto.EnterAmountDTO;
import com.example.demo.entity.TransactionEntity;

import java.util.List;

public interface SplitAmountService {

    void splitAmount(EnterAmountDTO enterAmountDTO);

    List<TransactionEntity> getUnsettledTransactions(Long groupId);
}
