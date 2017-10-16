package TestNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestEmployeeDetails {
	EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
	EmployeeDetails employee = new EmployeeDetails();

	@Test(priority = 5)
	public void testCalculateAppriasal() {

		employee.setName("Rajeev");
		employee.setAge(25);
		employee.setMonthlySalary(8000);

		System.out.println("testCalculateAppriasal");
		double appraisal = empBusinessLogic.calculateAppraisal(employee);
		Assert.assertEquals(500, appraisal, 0.0, "500");
	}

	// Test to check yearly salary
	@Test(priority = 1)
	public void testCalculateYearlySalary() {

		Reporter.log("started 2nd test case", 1);
		employee.setName("Rajeev");
		employee.setAge(25);
		employee.setMonthlySalary(8000);

		System.out.println("testCalculateYearlySalary");
		double salary = empBusinessLogic.calculateYearlySalary(employee);
		Assert.assertEquals(96000, salary, 0.0, "96000");

	}
	
}
