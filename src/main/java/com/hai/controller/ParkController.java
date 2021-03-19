package com.hai.controller;

import com.hai.pojo.MyMessage;
import com.hai.service.ItemService;
import com.hai.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenz at 18:54 on 2021/3/17
 */
@RestController
public class ParkController {

    @Autowired
    ParkService parkService;

    @Autowired
    ItemService itemService;

    @GetMapping("/getParks")
    public MyMessage getParks(){
        MyMessage myMessage = new MyMessage();
        myMessage.setData(parkService.getParks());
        return myMessage;
    }

    @GetMapping("/getParkById")
    public MyMessage getParkById(int id){
        MyMessage myMessage = new MyMessage();
        myMessage.setData(parkService.getParkById(id));
        return myMessage;
    }

    @PostMapping("/addItem")
    public MyMessage addItem(String parkName,String plate,String carname,String username,String tel, long duration, double cost){
        MyMessage myMessage = new MyMessage();
        boolean b = itemService.addItem(parkName, plate, carname, username, tel, duration, cost);
        if (b){
            myMessage.setMsg("添加成功");
        }else {
            myMessage.setCode(1);
            myMessage.setMsg("添加失败");
        }
        return myMessage;
    }

    @GetMapping("/getInfo")
    public MyMessage getInfo(int id){
        MyMessage myMessage = new MyMessage();
        myMessage.setData(itemService.getItemByParkId(id));
        return myMessage;
    }
}
