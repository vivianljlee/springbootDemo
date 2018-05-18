package com.estar.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.estar.demo.dao.UserMapper;
import com.estar.demo.dao.entity.User;


@Service("userService")
public class UserServiceImpl implements IUserService{

	@Resource(name="userDao") 
	private UserMapper userDao;
	
	public List<User> getUserList(int begin, int end) {
		
		return userDao.getUserList(begin, end);
	}

}
