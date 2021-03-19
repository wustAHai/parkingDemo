package com.hai.service;

import com.hai.mapper.AdminMapper;
import com.hai.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenz at 16:58 on 2021/3/16
 */
@Service
public class LoginService {

    @Autowired
    AdminMapper adminMapper;

    public boolean checkLogin(Admin admin){
        Admin adminByName = adminMapper.getAdminByName(admin.getName());
        if (adminByName==null||!adminByName.getPassword().equals(admin.getPassword())){
            return false;
        }
        return true;
    }

}
