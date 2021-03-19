package com.hai.mapper;

import com.hai.pojo.Park;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenz at 0:08 on 2021/3/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkMapperTest {

    @Autowired
    ParkMapper parkMapper;

    @Test
    public void addPark() {
        for (int i = 1; i < 51; i++) {
            Park park = new Park();
            String a = new String("P");
            if (i<10){
                a+=0;
            }
            park.setName(a+i);
            park.setRate(6.00);
            parkMapper.addPark(park);
        }
    }

    @Test
    public void getPark() {
        List<Park> park = parkMapper.getPark();
        System.out.println(park);
    }

    @Test
    public void getParkById() {
        Park p1 = parkMapper.getParkByName("p1");
        System.out.println(p1);
    }

    @Test
    public  void  upDateLocation (){
        int left =340;
        int top = 820;
        for (int i = 41; i < 51; i++) {
            parkMapper.updateLocation(left,top,i);
            left+=40;
        }
    }


}