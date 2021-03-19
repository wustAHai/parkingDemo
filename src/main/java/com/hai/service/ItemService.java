package com.hai.service;

import com.hai.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenz at 20:50 on 2021/3/18
 */

@Service
public class ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    CarService carService;

    @Transactional
    public boolean addItem(){
        return true;
    }
}
