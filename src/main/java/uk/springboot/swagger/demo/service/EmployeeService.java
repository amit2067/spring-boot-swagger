package uk.springboot.swagger.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.springboot.swagger.demo.beans.Employee;
import uk.springboot.swagger.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> showEmployees() {
		return employeeRepository.showEmployees();
	}

	public Employee viewEmployee(Long empId) {
		return employeeRepository.viewEmployee(empId);
	}

	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}

	public void updateEmployee(Long empId, Employee employee) {
		employeeRepository.updateEmployee(empId, employee);
	}
	
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteEmployee(empId);
	}

}
