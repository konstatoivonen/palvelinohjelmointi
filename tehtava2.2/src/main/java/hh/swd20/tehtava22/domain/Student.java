package hh.swd20.tehtava22.domain;

public class Student {
	
	private String firstName;
	private String lastName;
	
	public Student() {
		super();
		this.firstName = null;
		this.lastName = null;
		
	}
	
	public Student (String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

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
	@Override
	public String toString() {
		return "Friend [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
