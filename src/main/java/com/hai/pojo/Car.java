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
public class Car {
    private String plate;
    private String carname;
    private String username;
    private String tel;
}
