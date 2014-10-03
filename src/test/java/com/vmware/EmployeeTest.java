package com.vmware;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class EmployeeTest {

	@Test
	public void createEmployeeAndGetName() {
		Employee employee = new Employee();
		String name = "Ricardo Montalban";
		employee.setName(name);
		assertEquals(employee.getName(), name);
	}
	@Test
	public void addSocialSecurityNumber(){
		Employee employee =  new Employee();
		String ssn = "123-456-7890";
		employee.setSsn(ssn);
		assertEquals(employee.getSsn(), ssn);
	}
}
