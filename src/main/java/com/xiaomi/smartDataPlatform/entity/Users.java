package com.xiaomi.smartDataPlatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    private long id;
    private String name;
    private List<Platform> platforms;

}
