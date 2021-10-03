package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Service;
import com.model.Team;
import com.model.TeamMember;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("TeamMember")
@Api(value = "teamController", description = "Description for TeamMember Controller")
public class teamMemberController {

	@Autowired
	Service service;

	@PostMapping("save")

	@ApiOperation(value = "Save Team", httpMethod = "POST")
	public ResponseEntity<?> save(@RequestBody TeamMember e)
	{
		service.saveTeamMember(e);
		return ResponseEntity.ok(e+" saved");
	}

}
