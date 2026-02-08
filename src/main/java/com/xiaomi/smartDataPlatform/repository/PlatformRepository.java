package com.xiaomi.smartDataPlatform.repository;

import com.xiaomi.smartDataPlatform.entity.Platform;

import java.util.List;

public interface PlatformRepository {
    public Platform findById(long id);
    public Platform findByIdLazy(long id);
    public List<Platform> findAll();
}
