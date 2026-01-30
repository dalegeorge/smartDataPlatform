package com.xiaomi.smartDataPlatform.repository;

import com.xiaomi.smartDataPlatform.entity.Account;

import java.util.List;

public interface AccountRepository {
    public int save(Account account);
    public int update(Account account);
    public int deleteById(long id);
    public List<Account> findAll();
    public Account findById(long id);
    public Account findByName(String name);
    public long findById2(long id);
    public Account findByNameAndAge(String name,int age);
    public int count();
    public int count2();
    public String findNameById(long id);
}
