# Spring-Boot integration with Swagger

You should have jdk1.8 intstalled on your machine. This demo is built on Java 8.

Test the swaager-ui on following URL

http://localhost:8181/swagger-ui.html

Following micro services are deployed on this component.

1. http://localhost:8181/employee/showEmployees - GET  (provides list of all the employees)
2. http://localhost:8181/employee/viewEmployee/{empId} - GET (Retrieves employee details by providing Employee Id)
3. http://localhost:8181/employee/addEmployee - POST (Adds a new employee in the list)
4. http://localhost:8181/employee/updateEmployee/{empId} - PUT (updates an existing employee detail)
5. http://localhost:8181/employee/deleteEmployee/{empId} - DELETE (deletes an existing employee)
