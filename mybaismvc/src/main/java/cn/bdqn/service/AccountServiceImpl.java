package cn.bdqn.service;

import cn.bdqn.domain.Account;
import cn.bdqn.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    public List<Account> queryll() {
        System.out.println("查询所有信息");
        System.out.println("33333333333333333333333333333333333333333333");
        return accountMapper.selectAll();


    }

    public void save(Account account) {
       accountMapper.insert(account);
        System.out.println("添加信息");
    }
}
