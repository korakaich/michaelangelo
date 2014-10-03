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
		String ssn = "123-45-6789";
		employee.setSsn(ssn);
		assertEquals(employee.getSsn(), ssn);
	}
	@Test 
	public void fixDE30201_SocialSecurityMustBeACertainFormat() {
		String badSSN = "RamLikesNoOne";
		Employee employee = new Employee ();
		try{
			employee.setSsn(badSSN);
			fail("this line should have never been reached");
		}
		catch(IllegalArgumentException e){
			assertEquals(e.getMessage(), "RamLikesNoOne is not a valid social security number");
		}
	}
}
