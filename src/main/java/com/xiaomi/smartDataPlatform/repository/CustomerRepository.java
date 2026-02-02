package com.xiaomi.smartDataPlatform.repository;

import com.xiaomi.smartDataPlatform.entity.Customer;

public interface CustomerRepository {
    public Customer findById(long id);
}
