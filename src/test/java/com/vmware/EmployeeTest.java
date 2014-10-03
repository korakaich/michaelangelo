package com.vmware;

import static org.testng.Assert.*;

import java.util.regex.Pattern;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeeTest {

	private Employee employee;
	@BeforeMethod
	public void setUp(){
		System.out.println("Creating new employee");
		Pattern p = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
		employee = new Employee(p);
	}
	@DataProvider (name = "badSSNs")
	public Object[][] badSSNProvider(){
		return new Object[][]{
			{"asdasd", "asdasd is not a valid social security number"},
			{"RamLikesNoOne", "RamLikesNoOne is not a valid social security number"},
			{"341-133-4139", "341-133-4139 is not a valid social security number"},
			{"22", "22 is not a valid social security number"},
			{"    ", "Social security number cannot be blank"}
		};
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
	@Test (dataProvider = "badSSNs")
	public void fixDE30201_SocialSecurityMustBeACertainFormat(String badSSN, String expectedMessage) {		
		try{
			employee.setSsn(badSSN);
			fail("this line should have never been reached");
		}
		catch(IllegalArgumentException e){
			assertEquals(e.getMessage(), expectedMessage);
		}
	}
}
