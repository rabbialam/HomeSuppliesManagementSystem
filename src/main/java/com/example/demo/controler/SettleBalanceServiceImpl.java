package com.example.demo.controler;

import com.example.demo.endpoints.dto.SettleBalanceDTO;
import com.example.demo.entity.TransactionEntity;
import com.example.demo.entity.User;
import com.example.demo.entity.UserGroupEntity;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserGroupRepository;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Slf4j
@Service
public class SettleBalanceServiceImpl implements SettleBalanceService{

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserGroupRepository userGroupRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void settleBalanceFroGroup(SettleBalanceDTO settleBalanceDTO) {

        UserGroupEntity userGroupEntity = userGroupRepository.getOne(settleBalanceDTO.getGroupId());

        List<TransactionEntity> transactionEntityList = transactionRepository.findAllByUserGroupEntityAndStatus(userGroupEntity, 1);
        Double amount = 0.0;
        int groupMember = (int) userGroupEntity.getUserList().stream().count();
        for (TransactionEntity transaction: transactionEntityList) {
            amount = amount + transaction.getAmount();
        }
        Double centralFund = amount / groupMember;

        for (User user: userGroupEntity.getUserList()) {
            user.setBalance(centralFund - user.getBalance());
            userRepository.save(user);
        }
        System.out.println("before sorted---->" +userGroupEntity.getUserList());

        int numberUserGroupEntity = userGroupEntity.getUserList().size();
        List<User> sortedUserList = new ArrayList<User>(numberUserGroupEntity);
        for (User user : userGroupEntity.getUserList())
            sortedUserList.add(user);

        Collections.sort(sortedUserList, (first, second) -> (int) (first.getBalance() - second.getBalance()));

        System.out.println("after sorted---->" +sortedUserList);








    }
}
