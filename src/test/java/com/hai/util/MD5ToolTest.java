package com.hai.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenz at 14:31 on 2021/3/19
 */
public class MD5ToolTest {

    @Test
    public void getMD5() {
        String md5 = MD5Tool.getMD5("123456");
        System.out.println(md5);
    }
}