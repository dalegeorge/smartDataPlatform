package com.xiaomi.smartDataPlatform.entity;

import lombok.Data;

import java.util.List;

@Data
public class Products {
    private long id;
    private String name;
    private List<Customer> customers;
}
