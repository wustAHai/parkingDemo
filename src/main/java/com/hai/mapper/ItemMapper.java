package com.hai.mapper;

import com.hai.pojo.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by chenz at 0:39 on 2021/3/16
 */
@Mapper
public interface ItemMapper {

    @Insert("insert into item(start,duration,cost,car_plate,park_id) value(#{start},#{duration},#{cost},#{car.plate},#{park.id})")
    void addItem(Item item);

    @Select("select * from item")
    @Results(value = {
            @Result(property = "car",column = "car_plate",
            one = @One(select = "com.hai.mapper.CarMapper.getCarByPlate")),
            @Result(property = "park",column = "park_id",
            one = @One(select = "com.hai.mapper.ParkMapper.getParkByID"))
    })
    List<Item> getAllItems();


    @Select("select * from item where flag=0")
    @Results(value = {
            @Result(property = "car",column = "car_plate",
                    one = @One(select = "com.hai.mapper.CarMapper.getCarByPlate")),
            @Result(property = "park",column = "park_name",
                    one = @One(select = "com.hai.mapper.ParkMapper.getParkByName"))
    })
    List<Item> getParkingItems();

    @Update("update item set flag=1 where flag=0 and start+duration<#{cur}")
    void setItemsFlag(long cur);

    @Select("select * from item where flag=0 and park_id=#{id}")
    @Results(value = {
            @Result(property = "car",column = "car_plate",
                    one = @One(select = "com.hai.mapper.CarMapper.getCarByPlate")),
            @Result(property = "park",column = "park_id",
                    one = @One(select = "com.hai.mapper.ParkMapper.getParkByID"))
    })
    Item getItemByParkId(int id);
}
