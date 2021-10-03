package com.controller;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.model.Roles;
import com.model.Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("Roles")
@Api(value = "RoleController", description = "Description for Roles Controller")
public class RoleController {

	@Autowired
	Service service;

	@PostMapping("save")

	@ApiOperation(value = "Save Role", httpMethod = "POST")
	public ResponseEntity<?> save(@RequestBody Roles e)
	{
		service.saveRole(e);
		return ResponseEntity.ok(e+" saved");
	}
}
