package com.xiaomi.smartDataPlatform.repository;

import com.xiaomi.smartDataPlatform.entity.Platform;
import com.xiaomi.smartDataPlatform.entity.Users;

import java.util.List;


public interface UserRepository {
    public int save(Users users);
    public int update(Users users);
    public int deleteById(long id);
    public List<Users> findAll();
    public Users findById(long uid);
    public Users findByName(String username);
    public long findById2(long uid);
    public Users findByUidAndName(long uid, String name);
    public int count();
    public int count2();
    public String findNameById(long id);
}
