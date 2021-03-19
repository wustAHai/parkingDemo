package com.hai.mapper;

import com.hai.pojo.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenz at 23:33 on 2021/3/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarMapperTest {

    @Autowired
    CarMapper carMapper;

    @Test
    public void addCar() {
        Car car = new Car();
        car.setPlate("京A00001");
        car.setCarname("兰博基尼");
        car.setUsername("胡志勇");
        car.setTel("15623223117");
        carMapper.addCar(car);
    }

    @Test
    public void getAllCar() {
        List<Car> allCar = carMapper.getAllCar();
        for (Car car :
            allCar) {
            System.out.println(car);
        }
    }

    @Test
    public void getCarByPlate() {
        Car car = carMapper.getCarByPlate("京A00001");
        System.out.println(car);
    }
}