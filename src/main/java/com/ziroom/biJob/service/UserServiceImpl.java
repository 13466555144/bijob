package com.ziroom.biJob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziroom.biJob.dao.UserDao;
import com.ziroom.biJob.domain.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired 
    private UserDao userDao;  
 
    public User selectUserById(Integer userId) {  
        return userDao.selectUserById(userId);  
 
    }  

}
