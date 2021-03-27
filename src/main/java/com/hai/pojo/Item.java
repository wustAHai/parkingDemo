package com.hai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenz at 19:35 on 2021/3/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private int id;
    private long start;
    private long duration;
    private int flag;   //0--正在停车 1--已经结束  2--即将过期
    private double cost;
    private Car car;
    private Park park;
}
