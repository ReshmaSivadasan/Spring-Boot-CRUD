package com.example.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.UserService;

@RestController
public class userController {
	
	@Autowired
	private UserService userService;


	@GetMapping("/show/userInfo")
	public List<Employee> getUserInfo(){
		 return userService.getUserInfo();
	}
	
	@PutMapping("/put/userInfo/{firstName}")
	public void updateUserInfo(@RequestBody Employee emp, @PathVariable final String firstName){
		
		userService.updateUserInfo(emp, firstName);
		System.out.println("Update");
	}
	
	@PostMapping("/create/user")
	public void createUser(@RequestBody Employee emp){
		Employee employeeDetails = userService.saveUser(emp);
		
	}
	
	@DeleteMapping("/delete/userInfo/{id}")
	public void deleteUserInfo(@PathVariable int id ){
		
		userService.deleteUserInfo(id);
	}

}
