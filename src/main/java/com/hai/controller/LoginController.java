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

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by chenz at 16:47 on 2021/3/16
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public MyMessage login(String name,String password,String checkCode, HttpServletRequest request){
        MyMessage myMessage = new MyMessage();
        String checkCode1 = (String)request.getSession().getAttribute("checkCode");
        System.out.println(checkCode);
        System.out.println(checkCode1);
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(password);
        if (checkCode1!=null&&checkCode1.equalsIgnoreCase(checkCode)&&loginService.checkLogin(admin)){
            request.getSession().setAttribute("admin",admin);
            myMessage.setMsg("登陆成功！");
        }else {
            myMessage.setCode(1);
            myMessage.setMsg("登陆失败！");
        }
        return myMessage;
    }

    @GetMapping("/checkCode")
    public void  checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int width = 100;
        int height = 50;
        //1.创建一对象，在内存中图片(验证码图片对象)
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.PINK);//设置画笔颜色
        g.fillRect(0, 0, width, height);
        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random ran = new Random();
        g.setFont(new Font("宋体", Font.BOLD, 30));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符
            //2.3写验证码
            stringBuilder.append(ch);
            g.drawString(ch + "", width / 5 * i, height / 2);
        }
        //2.4画干扰线
        g.setColor(Color.GREEN);
        //随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }
        HttpSession session = request.getSession();
        session.setAttribute("checkCode", stringBuilder.toString());
        System.out.println(stringBuilder.toString());
        //3.将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
