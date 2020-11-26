package cn.bdqn.service;

import cn.bdqn.domain.Account;
import org.springframework.stereotype.Service;


import java.util.List;

public interface AccountService {
    //查询所有

      public List<Account> queryll();
      //添加
    public void save(Account account);

}
