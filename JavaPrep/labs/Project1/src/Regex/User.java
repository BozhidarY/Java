package nProjct;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements ValidatePhone{
	private String name;
	private String password;
	private String number;
	
	public User(String name, String password, String number) {
		this.name = name;
		this.password = password;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number){
		this.number = number;
	}

	@Override
	public boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {

		Pattern p1 = Pattern.compile("[0-9]{10,10}$");
		Matcher m = p1.matcher(getNumber());
		if (m.matches()) {
			return true;
		}
		else {
			return false;
		}
	}
}
