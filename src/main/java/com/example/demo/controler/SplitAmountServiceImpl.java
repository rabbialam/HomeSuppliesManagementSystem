package com.example.demo.controler;

import com.example.demo.endpoints.dto.EnterAmountDTO;
import com.example.demo.entity.TransactionEntity;
import com.example.demo.entity.User;
import com.example.demo.entity.UserGroupEntity;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserGroupRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SplitAmountServiceImpl implements SplitAmountService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserGroupRepository userGroupRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public void splitAmount(EnterAmountDTO enterAmountDTO) {

        UserGroupEntity userGroupEntity = userGroupRepository.getOne(enterAmountDTO.getGroupId());
        User user = userRepository.getOne(enterAmountDTO.getPaidBy());

        TransactionEntity transactionEntity = new TransactionEntity();

        transactionEntity.setAmount(enterAmountDTO.getAmount());
        transactionEntity.setUserGroupEntity(userGroupEntity);
        transactionEntity.setPaidBy(user);
        transactionEntity.setDate(System.currentTimeMillis()+"");
        transactionEntity.setStatus(1); //1 for unsettled
        user.setBalance(user.getBalance() + enterAmountDTO.getAmount());

        transactionRepository.save(transactionEntity);
        userRepository.save(user);

    }
}
