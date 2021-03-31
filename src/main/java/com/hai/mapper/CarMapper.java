package com.hai.mapper;

import com.hai.pojo.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by chenz at 23:23 on 2021/3/15
 */

@Mapper
public interface CarMapper {
    @Insert("insert into car value(#{plate},#{carname},#{username},#{tel})")
    void addCar(Car car);

    @Select("select * from car")
    List<Car> getAllCar();

    @Select("select * from car where plate=#{plate}")
    Car getCarByPlate(String plate);

    @Update("update car set carname=#{carname},username=#{username},tel=#{tel} where plate=#{pla.te}")
    void updateCar(Car car);
}
