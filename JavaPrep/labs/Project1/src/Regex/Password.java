package nProjct;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password{

	private Pattern pattern;

	private Matcher matcher;

	//declare a string pattern for username.

	private static final String PASSWORD_PATTERN = "^[[a-zA-Z]]{11,}$";
	
	public Password(){
		pattern = Pattern.compile(PASSWORD_PATTERN);

	}
	public boolean validateUserName(final String password){
		matcher = pattern.matcher(password);
		return matcher.matches();
	}
}
