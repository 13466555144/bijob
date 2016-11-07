package com.ziroom.biJob.dao;


import com.ziroom.biJob.domain.User;
 
public interface UserDao {
 
    /**
     * @param userId
     * @return User
     */
    public User selectUserById(Integer userId);  
 
}
