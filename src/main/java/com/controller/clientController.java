package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Service;


import com.model.Client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("Client")
@Api(value = "clientController", description = "Description for Client Controller")
public class clientController {

	@Autowired
	Service service;
	
	@PostMapping("save")
	@ApiOperation(value = "Save Client", httpMethod = "POST")
	public ResponseEntity<?> save(@RequestBody Client c)
	{
	service.saveClient(c);
	return ResponseEntity.ok(c+" saved");
	}
}
