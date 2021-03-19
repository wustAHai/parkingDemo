package com.hai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenz at 14:06 on 2021/3/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkInfo {
    private String parkName;
    private String plate;
    private String carname;
    private String tel;
    private String start;
    private String duration;
    private String username;
}
