package com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.model.Service;

import java.util.*;

import javax.transaction.Transactional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("Employee")
@Api(value = "EmployeeController", description = "Description for Employee Controller")
public class EmployeeController {
	@Autowired
	Service service;



	@GetMapping("getEmployee")
	@ApiOperation(value = "Get Employee Deatils ", httpMethod = "GET")
	public ResponseEntity<?> getEmployeeList(int id)
	{

		List<Employee> itemlist=service.empList(id);
		return new ResponseEntity(itemlist,HttpStatus.OK);
	}
	
	@GetMapping("getEmployeelist")
	@ApiOperation(value = "Get Employee Deatils ", httpMethod = "GET")
	public ResponseEntity<?> getEmployeeList()
	{

		List<Employee> itemlist=service.empList();
		return new ResponseEntity(itemlist,HttpStatus.OK);
	}

	@PostMapping("save")
	@ApiOperation(value = "Save Employee", httpMethod = "POST")
	public ResponseEntity<?> save(@RequestBody Employee e) 
	{
		service.save(e);
		return ResponseEntity.ok(e+" saved");
	}



	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empId){
		return new ResponseEntity<Employee>(service.findEmployee(empId), HttpStatus.OK);
	}


	@PostMapping("updateEmployee/{Id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="Id") int empId,
			@RequestBody Employee a ){
		if(service.update(empId,a)!=null)
		{
			return ResponseEntity.ok(a);
		}
		else
		{
			return new ResponseEntity("not updated ",HttpStatus.BAD_REQUEST);
		}



	}


}