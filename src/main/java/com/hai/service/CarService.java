package com.hai.service;

import com.hai.mapper.CarMapper;
import com.hai.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by chenz at 19:53 on 2021/3/18
 */
@Service
public class CarService {
    @Autowired
    CarMapper carMapper;

    public Car getCarByPalate(String palate){
        return  carMapper.getCarByPlate(palate);
    }

    public void addCar(Car car){
        carMapper.addCar(car);
    }

    public void updateCar(Car car){
        carMapper.updateCar(car);
    }
}
