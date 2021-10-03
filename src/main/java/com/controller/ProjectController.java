package com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Project;
import com.model.Service;
import com.model.TimeSheet;



import antlr.collections.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("ProjectController")
@Api(value = "ProjectController", description = "Description for ProjectController ")
public class ProjectController {
	@Autowired
	Service service;


	@GetMapping("getProjectStatus")
	@ApiOperation(value = "Get project details ", httpMethod = "GET")
	public ResponseEntity<?> getProjectStatus(int id)
	{

		Project status=service.trackStatus(id);

		return new ResponseEntity(status,HttpStatus.OK);
	}

	@PostMapping("save")
	@ApiOperation(value = "Save project", httpMethod = "POST")

	public ResponseEntity<?> saveProject(@RequestBody Project p)
	{
		service.saveProject(p);
		return ResponseEntity.ok(p+" saved");
	}

	@PostMapping("Close Project")
	@ApiOperation(value="close",httpMethod="POST")
	public ResponseEntity<?> closeProject(int id,String date, String projNotes)
	{
		if(service.closeProject(id,date,projNotes)!=null)
		{
			return ResponseEntity.ok(id +" Project Closed");
		}
		else
		{
			return new ResponseEntity("not Closed",HttpStatus.OK);
		}

	}

}