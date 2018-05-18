package com.estar.demo.dao;

import com.estar.demo.dao.entity.User;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component("userDao")
public interface UserMapper {
	
    int insert(User record);

    int insertSelective(User record);
    
    List<User> getUserList(@Param("begin") int begin,@Param("end")int end);
}