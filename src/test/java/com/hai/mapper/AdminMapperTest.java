package com.hai.mapper;

import com.hai.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenz at 19:54 on 2021/3/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminMapperTest {

    @Autowired
    AdminMapper adminMapper;

    @Test
    public void getAdminByName() {
        Admin root = adminMapper.getAdminByName("root");
        System.out.println(root);
    }
}