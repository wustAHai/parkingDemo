package com.hai.pojo;

import lombok.Data;

/**
 * Created by chenz at 19:35 on 2021/3/15
 */
@Data
public class Item {
    private int id;
    private long start;
    private long duration;
    private int flag;
    private double cost;
    private Car car;
    private Park park;
}
