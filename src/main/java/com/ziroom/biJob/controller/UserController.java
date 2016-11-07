package com.ziroom.biJob.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ziroom.biJob.domain.User;
import com.ziroom.biJob.service.UserService;
 
@Controller 
public class UserController {  
	
	Logger LOGGER = LoggerFactory.getLogger(UserController.class);
 
    @Resource 
    private UserService userService;  
 
    @RequestMapping("/test/showView.do")    
    public ModelAndView getIndex(){
    	LOGGER.info("ModelAndView is doing");
        ModelAndView mav = new ModelAndView("index");   
        User user = userService.selectUserById(1);  
        mav.addObject("user", user);   
        return mav;    
    }    
}