package com.example.demo.controler;

import com.example.demo.entity.TransactionEntity;
import com.example.demo.entity.UserGroupEntity;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SplitAmountServiceImpl implements SplitAmountService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserGroupRepository userGroupRepository;
    @Override
    public void splitAmount(Double amount, Long groupId) {

        UserGroupEntity userGroupEntity = userGroupRepository.getOne(groupId);

        TransactionEntity transactionEntity = new TransactionEntity();

        transactionEntity.setAmount(amount);
        transactionEntity.setUserGroupEntity(userGroupEntity);
        transactionEntity.setDate(System.currentTimeMillis()+"");

        transactionRepository.save(transactionEntity);

    }
}
