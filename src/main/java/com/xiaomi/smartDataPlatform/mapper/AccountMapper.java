package com.xiaomi.smartDataPlatform.mapper;

import com.xiaomi.smartDataPlatform.entity.Account;

import java.util.List;

public interface AccountMapper {
    public Integer save(Account account);
    public int update(Account account);
    public int deleteById(long id);
//    public List<Account> findAll();
//    public Account findById(long id);

}
