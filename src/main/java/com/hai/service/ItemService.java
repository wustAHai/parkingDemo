package com.hai.service;

import com.hai.mapper.ItemMapper;
import com.hai.mapper.ParkMapper;
import com.hai.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        duration = 24*3600*1000*duration;
        long  start = System.currentTimeMillis();
        Item item = new Item(0,start,duration,0,cost,car,parkByName);
        itemMapper.addItem(item);
        return true;
    }

    public ParkInfo getItemByParkId(int id){
        Item itemByParkId = itemMapper.getItemByParkId(id);
        if (itemByParkId==null){
            return new ParkInfo("P"+id,"无","无","无","无","无","无","无");
        }else {
            ParkInfo parkInfo = new ParkInfo();
            parkInfo.setParkName(itemByParkId.getPark().getName());
            parkInfo.setCarname(itemByParkId.getCar().getCarname());
            parkInfo.setPlate(itemByParkId.getCar().getPlate());
            parkInfo.setTel(itemByParkId.getCar().getTel());
            parkInfo.setDuration(itemByParkId.getDuration()/3600/1000/24+"");
            parkInfo.setUsername(itemByParkId.getCar().getUsername());
            parkInfo.setStart(new Date(itemByParkId.getStart()).toLocaleString());
            parkInfo.setEndTime(new Date(itemByParkId.getStart()+itemByParkId.getDuration()).toLocaleString());
            return parkInfo;
        }
    }

    @Transactional
    public void updateParksAndItems(){
        itemMapper.setItemsFlag(System.currentTimeMillis());
        itemMapper.setItemsFlag2(System.currentTimeMillis());
        parkMapper.updateType();
        parkMapper.updateType2();
    }

    public List<ItemInfo> getType2(){
        List<Item> type2 = itemMapper.getType2();
        List<ItemInfo> itemInfos = new ArrayList<>();
        for (Item item :
                type2) {
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.setId(item.getId());
            itemInfo.setPlate(item.getCar().getPlate());
            itemInfo.setTel(item.getCar().getTel());
            itemInfo.setUsername(item.getCar().getUsername());
            itemInfo.setEndTime(new Date(item.getStart()+item.getDuration()).toLocaleString());
            itemInfo.setParkName(item.getPark().getName());
            itemInfos.add(itemInfo);
        }
        return itemInfos;
    }

    @Transactional
    public void relent(int id,long duration,double cost){
        duration=duration*1000*3600*24;
        itemMapper.relent(id,duration,cost);
        parkMapper.updatePark(id);
    }
}
