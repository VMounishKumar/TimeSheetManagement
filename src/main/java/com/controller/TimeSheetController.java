package com.controller;



import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Service;
import com.model.TimeSheet;



import java.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("TimeSheet")
@Api(value = "TimeSheetController", description = "Description for TIMESHEET Controller")
public class TimeSheetController {
	@Autowired
	Service service;
	TimeSheet t;

	@GetMapping("getTimesheet")
	@ApiOperation(value = "Get Timesheet Details ", httpMethod = "GET")



	public ResponseEntity<?> getTimeDetails(int id)
	{

		List<TimeSheet> itemlist=service.findsheetDetails(id);
		return new ResponseEntity(itemlist,HttpStatus.OK);
	}

	
	@PostMapping("save")
	@ApiOperation(value = "Save Timesheet", httpMethod = "POST")
	public ResponseEntity<?> saveItems(@RequestBody TimeSheet t)
	{
		service.saveTimesheet(t);
		return new ResponseEntity(t,HttpStatus.OK);
	}
	
	
	@PostMapping("Approve")
	@ApiOperation(value="Approve",httpMethod="POST")
	public ResponseEntity<?> approveTimesheet(int id)
	{
		if(service.approveTimesheet(id))
		{
			return ResponseEntity.ok(id +" timesheet approved");
		}
		else
		{
			return new ResponseEntity("not approved",HttpStatus.BAD_REQUEST);
		}



	}
}