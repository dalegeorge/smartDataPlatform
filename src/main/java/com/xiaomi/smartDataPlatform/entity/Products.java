package com.xiaomi.smartDataPlatform.entity;

import lombok.Data;

@Data
public class Products {
    private long id;
    private String name;
    private Customer customers;
}
