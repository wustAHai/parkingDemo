package com.hai.controller;

import com.hai.pojo.MyMessage;
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
    public MyMessage addItem(){
        MyMessage myMessage = new MyMessage();

        return myMessage;
    }
}
