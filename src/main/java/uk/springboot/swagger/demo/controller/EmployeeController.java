package uk.springboot.swagger.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import uk.springboot.swagger.demo.beans.Employee;
import uk.springboot.swagger.demo.service.EmployeeService;

@Api(value="employee-service", description="Admin operations to deal with Employees")
@RequestMapping("/employee")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value = "View list of all employees",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the list"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@GetMapping("/showEmployees")
	public List<Employee> showEmployees() {
		return employeeService.showEmployees();
	}

	@ApiOperation(value = "Reterieve an Employee with an ID",response = Employee.class)
	@GetMapping("/viewEmployee/{empId}")
	public Employee viewEmployee(@PathVariable("empId") Long empId) {
		return employeeService.viewEmployee(empId);
	}

	@ApiOperation(value = "Add a new Employee")
	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	@ApiOperation(value = "Update an exitsting employee")
	@PutMapping("/updateEmployee/{empId}")
	public void updateEmployee(@PathVariable("empId") Long empId, Employee employee) {
		employeeService.updateEmployee(empId, employee);
	}
	
	@ApiOperation(value = "Delete an Employee")
	@DeleteMapping("/deleteEmployee/{empId}")
	public void deleteEmployee(@PathVariable("empId") Long empId) {
		employeeService.deleteEmployee(empId);
	}
	
}
