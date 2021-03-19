package com.hai.pojo;

import lombok.Data;

/**
 * Created by chenz at 13:06 on 2021/3/15  自定义消息类
 */
@Data
public class MyMessage {
    private int code;
    private Object data;
    private String msg;
}
