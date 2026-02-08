package com.xiaomi.smartDataPlatform.repository;

import com.xiaomi.smartDataPlatform.entity.Platform;
import com.xiaomi.smartDataPlatform.entity.Users;

import java.util.List;


public interface UserRepository {
    public List<Users> findAll();
    public Users findById(long uid);
    public Users findByIdLazy(long uid);

}
