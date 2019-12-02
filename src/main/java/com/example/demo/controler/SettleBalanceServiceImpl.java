package com.example.demo.controler;

import com.example.demo.endpoints.dto.SettleBalanceDTO;
import com.example.demo.entity.TransactionEntity;
import com.example.demo.entity.UserGroupEntity;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SettleBalanceServiceImpl implements SettleBalanceService{

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserGroupRepository userGroupRepository;

    @Override
    @Transactional
    public void settleBalanceFroGroup(SettleBalanceDTO settleBalanceDTO) {

        UserGroupEntity userGroupEntity = userGroupRepository.getOne(settleBalanceDTO.getGroupID());

        List<TransactionEntity> transactionEntityList = transactionRepository.findAllByUserGroupEntity(userGroupEntity);

        


    }
}
