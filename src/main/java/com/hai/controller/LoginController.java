package com.hai.controller;

import com.hai.pojo.Admin;
import com.hai.pojo.MyMessage;
import com.hai.service.LoginService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chenz at 16:47 on 2021/3/16
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public MyMessage login(Admin admin, HttpServletRequest request){
        MyMessage myMessage = new MyMessage();
        if (loginService.checkLogin(admin)){
            request.getSession().setAttribute("admin",admin);
            myMessage.setMsg("登陆成功！");
        }else {
            myMessage.setCode(1);
            myMessage.setMsg("登陆失败！");
        }
        return myMessage;
    }
}
