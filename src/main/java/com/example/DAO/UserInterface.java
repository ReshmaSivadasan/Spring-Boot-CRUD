package com.example.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public interface UserInterface extends JpaRepository<Employee, Integer> {

	Employee findByFirstName(String firstName);
	
}
