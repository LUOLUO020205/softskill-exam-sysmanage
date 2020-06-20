package com.softskill.exam.service.impl;

import com.softskill.exam.dao.UserMapper;
import com.softskill.exam.service.IIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityServiceImpl implements IIdentityService {

//    @Autowired
//    private UserMapper userMapper;

    public boolean checkPassword(String userName, String pwd) {
         if(userName.equals("admin")&&pwd.equalsIgnoreCase("1q2w3e4r5t")){
             return true;
         }
         return false;
    }

}
