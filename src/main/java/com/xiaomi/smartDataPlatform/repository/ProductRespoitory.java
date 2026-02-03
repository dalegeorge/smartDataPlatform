package com.xiaomi.smartDataPlatform.repository;


import com.xiaomi.smartDataPlatform.entity.Products;

public interface ProductRespoitory {
    public Products findById(long id);
}
