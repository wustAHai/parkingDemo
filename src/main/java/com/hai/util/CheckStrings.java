package com.hai.util;

/**
 * Created by chenz at 19:36 on 2021/3/15
 */
public class CheckStrings {
    public static boolean isValid(String... params) {
        if (params == null || params.length == 0) {
            return false;
        }
        for (int i = 0; i < params.length; i++) {
            if (params[i] == null || params[i].trim().equals("")) {
                return false;
            }
        }
        return true;
    }
}