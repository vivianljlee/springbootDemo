package com.estar.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estar.demo.dao.entity.User;
import com.estar.demo.service.IUserService;
import com.estar.util.JsonPluginsUtil;

@RestController
@RequestMapping("/custom")
public class CustomerController {
	
	@Resource(name="userService") 
	private IUserService userService;
	
	@RequestMapping("/hello")
    public String index() {

        return "Hello World q121";

    }
	
	@RequestMapping("/userList")
    public List<User> userList(String data) {
		
		Map map =JsonPluginsUtil.jsonToMap(data);
		String pageSize=(String) map.get("pageSize");
		String pageNo=(String) map.get("pageNo");
		
        return userService.getUserList(1, 10);

    }
}
