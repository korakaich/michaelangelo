package com.vmware;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
	private String name;
	private String ssn;
	private Matcher matcher;
	private Pattern pattern;

	public Employee(Pattern p) {
		pattern = p;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) throws IllegalArgumentException {
		matcher = pattern.matcher(ssn);
		if(ssn.trim().equals("")){
			throw new IllegalArgumentException("Social security number cannot be blank");
		}
		if (!matcher.matches()) {
			throw new IllegalArgumentException(ssn
					+ " is not a valid social security number");
		}
		this.ssn = ssn;
	}

	public static void main(String args){
		String sn = "   ";
		if(sn.matches(" *")){
			System.out.println("hello wts this shit");
		}
	}
}