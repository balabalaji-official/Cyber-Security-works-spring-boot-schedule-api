package com.csw.api.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.csw.api.entity.Employee;
import com.csw.api.entity.Schedule;
import com.csw.api.repository.EmployeeRepository;
//import com.csw.api.repository.ScheduleRepository;
import com.csw.api.support.DateInput;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;

	/*
	 * 
	 * Case 1 Post employee data to make a New Employee entry
	 * 
	 */
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public String addNewEmployee(@RequestBody Employee newEmployee) {
		Employee savedEmployee = employeeRepo.save(newEmployee);
		return "Employee id " + savedEmployee.getEmployeeId() + " is inserted with schedule id "
				+ savedEmployee.getSchedule().getSchedId();
	}

	/*
	 * 
	 * Case 1 Post list of employee data to make a New Employee entry
	 * 
	 */
	@PostMapping("/saveall")
	@ResponseStatus(HttpStatus.CREATED)
	public List<String> addNewEmployees(@RequestBody List<Employee> newEmployees) {
		List<String> all = new ArrayList<>();
		for (Employee newEmployee : newEmployees) {
			employeeRepo.deleteSchedule(newEmployee.getEmployeeId(), newEmployee.getSchedule().getSchedId());
			Employee savedEmployee = employeeRepo.save(newEmployee);
			all.add("Employee id " + savedEmployee.getEmployeeId() + " is inserted with schedule id "
					+ savedEmployee.getSchedule().getSchedId() + " ");
		}
		return all;
	}

	/*
	 * 
	 * Case 2 Get one employee's details and all his schedules employee id
	 */
	@GetMapping("/details/{id}")
	public List<Employee> getAllEmployeeId(@PathVariable Long id) {
		return employeeRepo.findByEmployeeId(id);
	}

	/*
	 * case 3 Mpdify and update one schedule by employee id
	 * 
	 * 
	 */
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String addSchedule(@RequestBody Schedule newSchedule, @PathVariable Long id) {
		Employee newEmployee = new Employee();
		newEmployee.setEmployeeId(id);
		newEmployee.setSchedule(newSchedule);
		employeeRepo.deleteSchedule(newEmployee.getEmployeeId(), newEmployee.getSchedule().getSchedId());
		Employee savedEmployee = employeeRepo.save(newEmployee);
		return "Employee id " + savedEmployee.getEmployeeId() + " is inserted with schedule id "
				+ savedEmployee.getSchedule().getSchedId();
	}

	/*
	 * 
	 * 
	 * Case 3 Modify and update list of schedules for employee id
	 * 
	 * 
	 */
	@PutMapping("/updateall/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<String> addAllSchedules(@RequestBody List<Schedule> newSchedules, @PathVariable Long id) {
		Employee newEmployee = new Employee();
		newEmployee.setEmployeeId(id);
		List<String> all = new ArrayList<>();
		for (Schedule newSchedule : newSchedules) {
			newEmployee.setSchedule(newSchedule);
			employeeRepo.deleteSchedule(newEmployee.getEmployeeId(), newEmployee.getSchedule().getSchedId());
			Employee savedEmployee = employeeRepo.save(newEmployee);
			all.add("Employee id " + savedEmployee.getEmployeeId() + " is inserted with schedule id "
					+ savedEmployee.getSchedule().getSchedId() + " ");
		}
		return all;
	}

	/*
	 * 
	 * Case 4 Delete Schedule by employee id and schedule id
	 * 
	 */
	@DeleteMapping("/delete/{employeeid}/{scheduleid}")
	@Transactional
	public String deleteSched(@PathVariable Long employeeid, @PathVariable Long scheduleid) {
		employeeRepo.deleteSchedule(employeeid, scheduleid);
		return "Deleted successfully";
	}

	/*
	 * 
	 * Case 5 Get Employee and Schedule Details of a particular date
	 * 
	 * 
	 */
	@GetMapping("/date")
	@Transactional
	public List<String> getDateDetails(@RequestBody DateInput dateOfDetails) {
		List<Employee> listEmployees = employeeRepo.getDateExistingDetails(dateOfDetails.getDateOfDetails());
		List<String> dateContain=new ArrayList<>();
		for(Employee addEmp:listEmployees) {
			dateContain.add(dateOfDetails.getDateOfDetails()+" time: "+addEmp.getSchedule().getTime()+" duration: "+addEmp.getSchedule().getDuration());
		}
		return dateContain;
	}

	/*
	 * 
	 * 
	 * General details
	 * 
	 */
	// get all the Employees details with schedule
	@GetMapping("/all")
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}
	
	//for deleting all from database
	@DeleteMapping("/deleteall")
	public String delAll() {
		employeeRepo.deleteAll();
		return "Deleted All";
	}
}
