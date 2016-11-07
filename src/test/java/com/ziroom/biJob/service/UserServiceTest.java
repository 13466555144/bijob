package com.ziroom.biJob.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziroom.biJob.baseTest.SpringTestCase;
import com.ziroom.biJob.domain.User;

public class UserServiceTest extends SpringTestCase {
	@Autowired 
    private UserService userService; 
 
    @Test 
    public void selectUserByIdTest(){  
        User user = userService.selectUserById(2);  
        System.out.println(user.getUserName() + ":" + user.getUserPassword());
    }  
}