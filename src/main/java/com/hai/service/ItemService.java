package com.hai.service;

import com.hai.mapper.ItemMapper;
import com.hai.mapper.ParkMapper;
import com.hai.pojo.Car;
import com.hai.pojo.Item;
import com.hai.pojo.Park;
import com.hai.pojo.ParkInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by chenz at 20:50 on 2021/3/18
 */

@Service
public class ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    CarService carService;

    @Autowired
    ParkService parkService;

    @Autowired
    ParkMapper parkMapper;

    @Transactional
    public boolean addItem(String parkName,String plate,String carname,String username,String tel, long duration, double cost){
        Park parkByName = parkService.getParkByName(parkName);
        if (parkByName==null||parkByName.getType()!=0){
            return false;
        }
        Car carByPalate = carService.getCarByPalate(plate);
        Car car = new Car(plate,carname,username,tel);
        if (carByPalate==null){
            carService.addCar(car);
        }else {
            carService.updateCar(car);
        }
        parkService.setType(parkName);
        duration = 3600*1000*duration;
        long  start = System.currentTimeMillis();
        Item item = new Item(0,start,duration,0,cost,car,parkByName);
        itemMapper.addItem(item);
        return true;
    }

    public ParkInfo getItemByParkId(int id){
        Item itemByParkId = itemMapper.getItemByParkId(id);
        if (itemByParkId==null){
            return new ParkInfo("P"+id,"无","无","无","无","无","无");
        }else {
            ParkInfo parkInfo = new ParkInfo();
            parkInfo.setParkName(itemByParkId.getPark().getName());
            parkInfo.setCarname(itemByParkId.getCar().getCarname());
            parkInfo.setPlate(itemByParkId.getCar().getPlate());
            parkInfo.setTel(itemByParkId.getCar().getTel());
            parkInfo.setDuration(itemByParkId.getDuration()/3600/1000+"");
            parkInfo.setUsername(itemByParkId.getCar().getUsername());
            parkInfo.setStart(new Date(itemByParkId.getStart()).toLocaleString());
            return parkInfo;
        }
    }

    @Transactional
    public void updateParksAndItems(){
        itemMapper.setItemsFlag(System.currentTimeMillis());
        parkMapper.updateType();
    }
}
