package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;
import com.example.service.UserService;

@RestController
public class TestController {

	@Autowired
	UserService userService;

	@ResponseBody
	@GetMapping("/test")
	public String getView() {
		return "test";
	}

	@ResponseBody
	@PostMapping("/create")
	public void createUser(HttpServletRequest request) {
		User user = new User();
		user.setCountry("India");
		user.setName("Suraj");
		userService.createUser(user);
	}

	@ResponseBody
	@GetMapping("/userDetails")
	public User getUserDetailsById(HttpServletRequest request) {
		return userService.findById(1);
	}

	@ResponseBody
	@GetMapping("/allUserDetails")
	public List<User> getALlUsersDetails() {
		return userService.getUser();
	}

	@ResponseBody
	@GetMapping("/delete")
	public String deleteUserById(HttpServletRequest request) {
		userService.deleteUserById(Long.parseLong(request.getParameter("id")));
		return "user removed";
	}

	@ResponseBody
	@GetMapping("/upadate")
	public String partiallyUpdateUser(HttpServletRequest request) {
		userService.updatePartially(Long.parseLong(request.getParameter("id")));
		return "user partially updated";
	}
	
	@GetMapping("/upadateByID")
	public String UpdateUser(HttpServletRequest request) {
		userService.UpdateUserById("Mumbai",2l);
		return "updated";
	}
	
	@GetMapping("/sayHello")
	public String sayHello(){
		return "Hello";
	}
	

}
