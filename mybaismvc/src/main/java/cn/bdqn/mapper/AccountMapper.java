package cn.bdqn.mapper;

import cn.bdqn.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountMapper {
    // 查询所有的账号
    public List<Account> selectAll();

    // 保存账号
    public void insert(Account account);
}
