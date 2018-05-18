package com.estar.demo.service;

import java.util.List;

import com.estar.demo.dao.entity.User;

public interface IUserService {
	List<User> getUserList(int begin,int end);
}
