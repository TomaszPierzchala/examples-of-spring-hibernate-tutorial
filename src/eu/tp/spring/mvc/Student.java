package eu.tp.spring.mvc;

import java.util.Arrays;

public class Student {
	private String firstName, lastName, country, gender;
	private String [] oss;
	private final String [] ossLabels = {"Android", "Windows", "Linux", "Mac OS"};
	private final String [] genderLabels = {"man", "woman"};

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public Student() {
		super();
		this.firstName = "first name ?";
		this.lastName = "family name ?";
		this.country = "POL";
		this.oss = new String [] {"Linux", "Mac OS", "Windows"};
		this.gender = "man";
		System.out.println("Student() is called");
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public String[] getOss() {
		return oss;
	}

	public void setOss(String[] os) {
		this.oss = os;
	}

	public String[] getOssLabels() {
		return ossLabels;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + ", prefered OS="
				+ Arrays.toString(oss) + "]";
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getGenderLabels() {
		return genderLabels;
	}
}
