package com.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;



@Api(basePath = "swagger-demo/department", value = "Department", 
	description = "Operations with department", produces = "application/json")
@RestController
@RequestMapping(value = "swagger-demo/department", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {
	@Autowired
	private DepartmentRepository repo;
	static final Logger logger = LogManager.getLogger(DepartmentController.class.getName());

	// Create Department
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value="/department/create")
	@ResponseBody
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ApiOperation(value = "Create Department", notes = "Fetch List of Person")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "List"),
            @ApiResponse(code = 500, message = "Error occurred while fetching Person")
    })	
	public String createDepartment(String name, double salar_min_range, double salar_max_range) throws Exception {
		Department dept = new Department(name, salar_min_range, salar_max_range);
		repo.save(dept);
		throw new Exception("Exception");
	}

	// Get Department Details
	@Transactional
	@RequestMapping(method = RequestMethod.GET, value="/department/read")
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ApiOperation(value = "Get Department", notes = "Fetch List of Person")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "List"),
            @ApiResponse(code = 500, message = "Error occurred while fetching Person")
    })
	public String getDept(long id) throws Exception {
		Department dept;
		dept = repo.findOne(id);
		if (dept == null) {
			String errorMsg = "no department found for id " + id;
			throw new Exception(errorMsg);
		} else {
			return dept.getId() + " : " + dept.getName();
		}
	}

}
