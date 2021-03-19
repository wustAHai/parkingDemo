package com.hai.pojo;

import lombok.Data;

/**
 * Created by chenz at 19:36 on 2021/3/15
 */
@Data
public class Park {
    private int id;
    private String name;
    private int type;
    private double rate;
    private String des;
    private int left;
    private int top;
}
