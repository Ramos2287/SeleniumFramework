package utilities;

import com.github.javafaker.Faker;

public class JavaFaker {
	private String fname;
	private String lname;
	private String email;
	private String password;

	public void datafake() {
		Faker fakeData = new Faker();
		fname = fakeData.name().firstName();
		lname = fakeData.name().lastName();
		email = fakeData.internet().emailAddress();
		password = fakeData.number().digits(8).toString();
	}

	public String getFirstName() {
		return fname;
	}

	public String getLastName() {
		return lname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
