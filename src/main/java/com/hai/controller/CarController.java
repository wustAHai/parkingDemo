package com.hai.controller;

import com.hai.pojo.Car;
import com.hai.pojo.MyMessage;
import com.hai.service.CarService;
import com.hai.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenz at 19:53 on 2021/3/18
 */
@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/getCarByPlate")
    public MyMessage getCarByPlate(String plate){
        MyMessage myMessage = new MyMessage();
        Car carByPalate = carService.getCarByPalate(plate);
        if (carByPalate==null){
            myMessage.setCode(1);
        }
        myMessage.setData(carByPalate);
        return myMessage;
    }
}
