package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.DAO.UserInterface;
import com.example.entity.Employee;

@Component
public class userServiceImpl implements UserService {

	@Autowired
	private UserInterface userInterface;

	public List<Employee> getUserInfo() {

		//List<Map<String, Object>> userDetails = jdbcTemplate.queryForList("Select id,first_name,last_name,email from employee limit 5");

		List<Employee> userDetails = userInterface.findAll();
		return userDetails;

	}

	public void updateUserInfo(Employee emp, String firstName) {
		
		Employee updateEmp = userInterface.findByFirstName(firstName);
		
		if(updateEmp != null){
			updateEmp.setEmail(emp.getEmail());
			updateEmp.setFirstName(emp.getFirstName());
			updateEmp.setLastName(emp.getLastName());
			
		}

		userInterface.save(updateEmp);

	}
	
	public Employee saveUser(Employee emp){
		
		userInterface.save(emp);
		return emp;
	}

	public void deleteUserInfo(int id) {

		userInterface.deleteById(id);

	}

}
