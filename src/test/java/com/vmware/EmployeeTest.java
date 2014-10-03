package com.vmware;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeTest {

	private Employee employee;
	@BeforeMethod
	public void setUp(){
		System.out.println("Creating new employee");
		employee = new Employee();
	}
	@Test
	public void createEmployeeAndGetName() {
		String name = "Ricardo Montalban";
		this.employee.setName(name);
		assertEquals(employee.getName(), name);
	}
	@Test
	public void addSocialSecurityNumber(){
		String ssn = "123-45-6789";
		this.employee.setSsn(ssn);
		assertEquals(employee.getSsn(), ssn);
	}
	@Test
	public void addAnotherSocialSecurityNumber(){
		String ssn = "193-45-6989";
		employee.setSsn(ssn);
		assertEquals(employee.getSsn(), ssn);
	}
	@Test 
	public void fixDE30201_SocialSecurityMustBeACertainFormat() {
		String badSSN = "RamLikesNoOne";
		try{
			employee.setSsn(badSSN);
			fail("this line should have never been reached");
		}
		catch(IllegalArgumentException e){
			assertEquals(e.getMessage(), "RamLikesNoOne is not a valid social security number");
		}
	}
}
