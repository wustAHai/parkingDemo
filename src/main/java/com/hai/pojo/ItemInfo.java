package com.hai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenz at 10:10 on 2021/3/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemInfo {
    private int id;
    private String parkName;
    private String plate;
    private String username;
    private String tel;
    private String endTime;
}
