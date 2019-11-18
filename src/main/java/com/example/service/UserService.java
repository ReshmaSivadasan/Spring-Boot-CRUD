package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Employee;

@Service

public interface UserService {
	List<Employee> getUserInfo();

	void updateUserInfo(Employee emp, String firstName);
	
	void deleteUserInfo(int id);
}
