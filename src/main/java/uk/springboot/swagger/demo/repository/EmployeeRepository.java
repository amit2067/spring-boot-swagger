package uk.springboot.swagger.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import uk.springboot.swagger.demo.beans.Employee;

@Repository
public class EmployeeRepository {
	
	private static List<Employee> empList;
	
	static {
		empList = getEmployeeList();
	}

	public List<Employee> showEmployees() {
		return empList;
	}

	public Employee viewEmployee(Long empId) {
		return empList.stream().filter(emp -> emp.getEmpId().equals(empId)).findAny().orElse(null);
	}

	public void addEmployee(Employee employee) {
		empList.add(employee);
	}

	public void updateEmployee(Long empId, Employee employee) {
		Employee empl = empList.stream().filter(emp -> emp.getEmpId().equals(empId)).findAny().orElse(null);
		empl.setEmpId(employee.getEmpId());
		empl.setDesignation(employee.getDesignation());
		empl.setEmailAddress(employee.getEmailAddress());
		empl.setName(employee.getName());
	}
	
	public void deleteEmployee(Long empId) {
		Employee empl = empList.stream().filter(emp -> emp.getEmpId().equals(empId)).findAny().orElse(null);
		empList.remove(empl);
	}
	
	private static List<Employee> getEmployeeList() {
		List<Employee> empList = new ArrayList<>();
		Employee employee1 = new Employee(Long.valueOf(811), "Amit Batra", "amitb@gmail.com", "SE");
		Employee employee2 = new Employee(Long.valueOf(812), "Amit Taya", "amitt@gmail.com", "SE");
		Employee employee3 = new Employee(Long.valueOf(813), "Amit Mishra", "amitm@gmail.com", "SE");
		Employee employee4 = new Employee(Long.valueOf(814), "Amit Rajput", "amitr@gmail.com", "SE");
		empList.add(employee1);
		empList.add(employee2);
		empList.add(employee3);
		empList.add(employee4);
		return empList;
	}

}
