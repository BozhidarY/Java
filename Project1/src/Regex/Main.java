package nProjct;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws WrongPhoneNumberException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Signin or Signup");
		
		String keyword = scanner.nextLine();  
		
		if (keyword.equals("signup")) {
			User u = new User("Bojidar", "kafkn", "0886788808");
			
			System.out.println(u.getName() + " " + u.getNumber());
			System.out.println(u.validatePhoneNumber(u.getNumber()));
		}
		else if(keyword.equals("signin")) {
			User[] u = new User[2];
			u[0] = new User("Bojidar", "kafkn", "0886788808");
			u[1] = new User("Ivan", "kafkn", "088678880o");
			
			System.out.println(u[1].getName() + " " + u[1].getNumber());
		}	
	}
}
