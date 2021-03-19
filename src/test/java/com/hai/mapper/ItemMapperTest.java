package com.hai.mapper;

import com.hai.pojo.Car;
import com.hai.pojo.Item;
import com.hai.pojo.Park;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenz at 11:10 on 2021/3/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperTest {

    @Autowired
    ItemMapper itemMapper;

    @Test
    public void addItem() {
        Item item = new Item();
        Park park = new Park();
        park.setType(1);
        park.setName("P1");
        park.setRate(6.00);
        Car car = new Car();
        car.setPlate("京A00001");
        car.setCarname("兰博基尼");
        car.setUsername("胡志勇");
        car.setTel("15623223117");
        item.setCar(car);
        item.setPark(park);
        item.setStart(System.currentTimeMillis());
        item.setDuration(1000*3600);
        itemMapper.addItem(item);
    }

    @Test
    public void getAllItems() {
        List<Item> allItems = itemMapper.getAllItems();
        for (Item item :
                allItems) {
            System.out.println(item);
        }
    }

    @Test
    public void getParkingItems(){
        List<Item> allItems = itemMapper.getParkingItems();
        for (Item item :
                allItems) {
            System.out.println(item);
        }
    }

    @Test
    public void getNumberOfItems(){
        int p1 = itemMapper.getNumberOfItems("P1");
        System.out.println(p1);
    }

    @Test
    public void setItemsFlag(){
         itemMapper.setItemsFlag(System.currentTimeMillis());
    }
}