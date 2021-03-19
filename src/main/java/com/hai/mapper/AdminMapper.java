package com.hai.mapper;

import com.hai.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by chenz at 19:38 on 2021/3/15
 */
@Mapper
public interface AdminMapper {

    @Select("select * from admin where name = #{name}")
    Admin getAdminByName(String name);
}
