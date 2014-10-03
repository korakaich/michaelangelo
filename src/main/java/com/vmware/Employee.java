package com.vmware;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
	private String name;
	private String ssn;

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

		Pattern pattern = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
		Matcher matcher = pattern.matcher(ssn);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(ssn+ " is not a valid social security number");
		}
		this.ssn = ssn;
	}
}