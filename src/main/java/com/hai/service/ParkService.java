package com.hai.service;

import com.hai.mapper.ParkMapper;
import com.hai.pojo.Item;
import com.hai.pojo.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenz at 19:01 on 2021/3/17
 */
@Service
public class ParkService {
    @Autowired
    private ParkMapper parkMapper;

    public List<Park> getParks(){
        return  parkMapper.getPark();
    }

    public Park getParkById(int id){
       return parkMapper.getParkByID(id);
    }

    public Park getParkByName(String parkName){
        return parkMapper.getParkByName(parkName);
    }

    public void setType(String parkName){
        parkMapper.setType(parkName);
    }

    public int[] getParkNumInfo(){
        int[] ints = new int[2];
        ints[0]= parkMapper.getAvailablePark();
        ints[1]= parkMapper.getOccupiedPark();
        return ints;
    }

    public List<Integer> getCounts(){
        List<Integer> counts = parkMapper.getCounts();
        return counts;
    }


}
