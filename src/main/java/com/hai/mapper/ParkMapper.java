package com.hai.mapper;

import com.hai.pojo.Park;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by chenz at 23:54 on 2021/3/15
 */
@Mapper
public interface ParkMapper {
    @Insert("insert into park value(#{name},#{type},#{rate},#{des},#{left},#{top})")
    void addPark(Park park);

    @Select("select * from park")
    List<Park> getPark();

    @Select("select * from park where name=#{name}")
    Park getParkByName(String name);

    @Select("select * from park where id=#{id}")
    Park getParkByID(int id);

    @Update("update park set type=1 where name=#{name}")
    void setType(String name);

    @Update("update park set type=0 where (type=1 or type=2) and id not in (select park_id from item where flag=0 or flag=2)")
    void updateType();

    @Update("update park set type=2 where type!=2 and id in (select park_id from item where flag=2)")
    void updateType2();

    @Update("update park set `left` =#{left},top=#{top} where id=#{id}")
    void updateLocation(int left,int top,int id);

    @Select("select count(*) from park where type=0")
    int getAvailablePark();

    @Select("select count(*) from park where type!=0")
    int getOccupiedPark();

    @Select("select count(*) from park  group by type order by type")
    List<Integer> getCounts();

    @Update("update park set type = 1 where id in (select park_id from item where id=#{id})")
    void updatePark(int id);
}
