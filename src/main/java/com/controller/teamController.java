package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Roles;
import com.model.Service;
import com.model.Team;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("Team")
@Api(value = "teamController", description = "Description for Team Controller")
public class teamController {

	@Autowired
	Service service;

	@PostMapping("save")

	@ApiOperation(value = "Save Team", httpMethod = "POST")
	public ResponseEntity<?> save(@RequestBody Team e)
	{
		service.saveTeam(e);
		return ResponseEntity.ok(e+" saved");
	}
}
