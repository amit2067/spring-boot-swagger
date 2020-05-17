package uk.springboot.swagger.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.springboot.swagger.demo.beans.Employee;
import uk.springboot.swagger.demo.controller.EmployeeController;
import uk.springboot.swagger.demo.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class SpringBootSwaggerAppTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void testShowEmployees() throws Exception {

		Mockito.when(employeeService.showEmployees()).thenReturn(new ArrayList<>());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/showEmployees")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult mockMvcResult = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[]";
		JSONAssert.assertEquals(expected, mockMvcResult.getResponse().getContentAsString(), false);
	}

	@Test
	public void testViewEmployee() throws Exception {

		Long empId = 812L;
		Mockito.when(employeeService.viewEmployee(empId)).thenReturn(new Employee());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/viewEmployee/"+empId)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult mockMvcResult = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{}";
		JSONAssert.assertEquals(expected, mockMvcResult.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testAddEmployee() throws Exception {

		Employee employee = new Employee(819L, "test", "test@gmail.com", "test designation");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee/addEmployee")
				.accept(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(employee))
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mockMvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.CREATED.value(), mockMvcResult.getResponse().getStatus());
	}
	
	@Test
	public void updateEmployee() throws Exception {

		Long empId = 812L;
		Employee employee = new Employee(empId, "test", "test@gmail.com", "test designation");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/employee/updateEmployee/"+empId)
				.accept(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(employee))
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mockMvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), mockMvcResult.getResponse().getStatus());
	}
	
	@Test
	public void deleteEmployee() throws Exception {

		Long empId = 812L;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/employee/deleteEmployee/"+empId)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult mockMvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), mockMvcResult.getResponse().getStatus());
	}

}
