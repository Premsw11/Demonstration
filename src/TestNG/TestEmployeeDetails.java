package TestNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestEmployeeDetails {
	EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
	   EmployeeDetails employee = new EmployeeDetails();

	   @Test
	   public void testCalculateAppriasal() {
	   
	      employee.setName("Rajeev");
	      employee.setAge(25);
	      employee.setMonthlySalary(8000);
	      
	      double appraisal = empBusinessLogic.calculateAppraisal(employee);
	      Assert.assertEquals(500, appraisal, 0.0, "500");
	   }

	   // Test to check yearly salary
	   @Test
	   public void testCalculateYearlySalary() {
	   
		  Reporter.log("started 2nd test case", 1);
		  employee.setName("Rajeev");
	      employee.setAge(25);
	      employee.setMonthlySalary(8000);
	      
	      double salary = empBusinessLogic.calculateYearlySalary(employee);
	      Assert.assertEquals(9600, salary, 0.0, "8000");
	     
	   }
}
